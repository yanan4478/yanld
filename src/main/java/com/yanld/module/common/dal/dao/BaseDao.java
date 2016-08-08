package com.yanld.module.common.dal.dao;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.yanld.module.common.dal.dataobject.BaseDO;
import com.yanld.module.common.dal.query.BaseQuery;
import com.yanld.module.common.util.RedisUtils;
import com.yanld.module.common.util.StackTraceUtils;
import javafx.util.Pair;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanan on 16/7/8.
 */
public abstract class BaseDao {
    private static final Logger logger = LoggerFactory.getLogger(BaseDao.class);
    @Resource
    protected SqlSession sqlSession;

    @Resource
    protected RedisTemplate<Serializable, Serializable> redisTemplate;

    protected <T extends BaseDO> int setObjectToRedis(String objectKey, T dto) {
        return RedisUtils.setObject(redisTemplate, objectKey, dto);
    }

    protected <T extends BaseDO> int setObjectToRedis(T dto) {
        return setObjectToRedis(dto.getClass().getSimpleName() + ":" + dto.getId(), dto);
    }

    protected <T extends BaseDO> int setObjectToRedisWithList(String objectKey, T dto) {
        return RedisUtils.setObject(redisTemplate, objectKey, dto) & setObjectToList(dto);
    }

    private <T extends BaseDO> int setObjectToList(T dto) {
        try {
            String queryName = getQueryName(dto);
            Class qryClz = Class.forName(queryName);
            BaseQuery query = (BaseQuery) qryClz.newInstance();
            operationInList(dto, query, dto.getId(), true);
            return 1;
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return 0;
        }
    }

    protected <T extends BaseDO> int setObjectToRedisWithList(T dto) {
        return setObjectToRedisWithList(dto.getClass().getSimpleName() + ":" + dto.getId(), dto);
    }

    protected int deleteObjectInRedis(BaseDO dto) {
        return deleteObjectFromList(dto) &
                RedisUtils.delete(redisTemplate, dto.getClass().getSimpleName() + ":" + dto.getId());
    }

    private int deleteObjectFromList(BaseDO dto) {
        try {
            String queryName = getQueryName(dto);
            BaseQuery query = (BaseQuery) Class.forName(queryName).newInstance();
            operationInList(dto, query, dto.getId(), false);
            return 1;
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return 0;
        }
    }

    private <T extends BaseDO, Q extends BaseQuery> void operationInList(T dto, Q query, long id, boolean set) throws Exception {
        Field[] qryFields = query.getClass().getDeclaredFields();
        String[] qryFieldNames = new String[qryFields.length];
        for (int i = 0; i < qryFields.length; i++) {
            qryFieldNames[i] = qryFields[i].getName();
        }
        Field[] fields = dto.getClass().getDeclaredFields();
        List<Pair<String, Object>> queryPairs = new ArrayList<>();
        for (String qryFieldName : qryFieldNames) {
            for (Field field : fields) {
                field.setAccessible(true);
                if ((Number.class.isInstance(field.get(dto))
                        || field.getType().isInstance(String.class))
                        && qryFieldName.equals(field.getName())) {
                    queryPairs.add(new Pair<>(qryFieldName, field.get(dto)));
                }
            }
        }
        String keyList = getBaseListName(dto);
        for (int i = 0; i < Math.pow(2, queryPairs.size()); i++) {
            for (int j = i, k = 0; j > 0; j = j >> 1, k++) {
                if (j % 2 == 1) {
                    Pair<String, Object> pair = queryPairs.get(k);
                    keyList += ("_" + pair.getKey() + ":" + pair.getValue());
                }
            }
            if (set) {
                RedisUtils.leftPush(redisTemplate, keyList, String.valueOf(id));
            } else {
                RedisUtils.deleteFromList(redisTemplate, keyList, 1, String.valueOf(id));
            }
        }
    }

    protected <T extends BaseDO> T getObjectInRedis(String objectKey, T dto) {
        return RedisUtils.getObject(redisTemplate, objectKey, dto);
    }

    protected <T extends BaseDO> List<T> getObjectListInRedis(BaseQuery query, T dto) {
        try {
            String key = getBaseListName(query.getClass().getSimpleName().replace("Query", "DO"));
            Field[] qryFields = query.getClass().getDeclaredFields();
            for (Field field : qryFields) {
                if (field.get(query) != null) {
                    key += ("_" + field.getName() + ":" + String.valueOf(field.get(query)));
                }
            }
            long start = query.getOffset() + 1;
            long end = start + query.getLimit() - 1;
            List<String> idList = RedisUtils.getList(redisTemplate, key, start, end);
            return getObjectListInRedis(idList, dto);
        } catch (IllegalAccessException e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return Lists.newArrayList();
        }
    }

    protected long getObjectCount(BaseQuery query) {
        try {
            String key = getQueryKey(query);
            return RedisUtils.getListCount(redisTemplate, key);
        } catch (IllegalAccessException e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return 0;
        }
    }

    private String getQueryKey(BaseQuery query) throws IllegalAccessException {
        String key = getBaseListName(query.getClass().getSimpleName().replace("Query", "DO"));
        Field[] qryFields = query.getClass().getDeclaredFields();
        for (Field field : qryFields) {
            if (field.get(query) != null) {
                key += ("_" + field.getName() + ":" + String.valueOf(field.get(query)));
            }
        }
        return key;
    }

    protected <T extends BaseDO> List<T> getObjectListInRedis(List<String> ids, T dto) {
        return RedisUtils.getList(redisTemplate, ids, dto);
    }

    protected <T extends BaseDao> String getEntityName(T dao) {
        return dao.getClass().getSimpleName().replace("DaoImpl", "DO");
    }

    protected <T extends BaseDO> String getBaseListName(T dto) {
        return getBaseListName(dto.getClass().getSimpleName());
    }

    protected String getBaseListName(String nameDO) {
        return Joiner.on("").join(nameDO, "List");
    }

    protected <T extends BaseDO> String getQueryName(T dto) {
        return dto.getClass().getName().replace("dataobject.YanldArticleDO", "query.YanldArticleQuery");
    }

    protected <T extends BaseDao> String getObjectKeyInRedis(T dao, long id) {
        return getEntityName(dao) + ":" + id;
    }

    protected <T extends BaseDO> List<String> toRedisIds(List<Long> ids, T dto){
        List<String> resultList = new ArrayList<>();
        String dtoName = dto.getClass().getSimpleName();
        for(Long id : ids) {
            String redisId = Joiner.on("").join(dtoName,":",id);
            resultList.add(redisId);
        }
        return resultList;
    }
}
