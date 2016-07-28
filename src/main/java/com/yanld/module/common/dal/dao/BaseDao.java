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

    protected <T extends BaseDO> int setObjectToRedis(String objectKey, T t) {
        return RedisUtils.setObject(redisTemplate, objectKey, t);
    }

    protected <T extends BaseDO> int setObjectToRedis(T t) {
        return setObjectToRedis(t.getClass().getSimpleName() + ":" + t.getId(), t);
    }

    protected <T extends BaseDO> int setObjectToRedisWithList(String objectKey, T t) {
        return RedisUtils.setObject(redisTemplate, objectKey, t) & setObjectToList(t);
    }

    private <T extends BaseDO> int setObjectToList(T t) {
        try {
            String queryName = getQueryName(t);
            Class qryClz = Class.forName(queryName);
            BaseQuery query = (BaseQuery) qryClz.newInstance();
            operationInList(t, query, String.valueOf(t.getId()), true);
            return 1;
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return 0;
        }
    }

    protected <T extends BaseDO> int setObjectToRedisWithList(T t) {
        return setObjectToRedisWithList(t.getClass().getSimpleName() + ":" + t.getId(), t);
    }

    protected int deleteObjectInRedis(String key) {
        return RedisUtils.delete(redisTemplate, key) & deleteObjectFromList(key);
    }

    private int deleteObjectFromList(String key) {
        try {
            String[] info = key.split(":");
            String nameDO = info[0];
            String id = info[1];
            String queryName = nameDO.replace("DO", "Query");
            BaseDO pojo = (BaseDO) Class.forName(nameDO).newInstance();
            BaseQuery query = (BaseQuery) Class.forName(queryName).newInstance();
            operationInList(pojo, query, id, false);
            return 1;
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return 0;
        }
    }

    private <T extends BaseDO, Q extends BaseQuery> void operationInList(T pojo, Q query, String id, boolean set) throws Exception {
        Field[] qryFields = query.getClass().getDeclaredFields();
        String[] qryFieldNames = new String[qryFields.length];
        for (int i = 0; i < qryFields.length; i++) {
            qryFieldNames[i] = qryFields[i].getName();
        }
        Field[] fields = pojo.getClass().getDeclaredFields();
        List<Pair<String, Object>> queryPairs = new ArrayList<>();
        for (String qryFieldName : qryFieldNames) {
            for (Field field : fields) {
                if ((field.getType().isInstance(Number.class)
                        || field.getType().isInstance(String.class))
                        && qryFieldName.equals(field.getName())) {
                    queryPairs.add(new Pair<>(qryFieldName, field.get(pojo)));
                }
            }
        }
        String keyList = getBaseListName(pojo);
        for (int i = 0; i < Math.pow(2, queryPairs.size()); i++) {
            for (int j = i, k = 0; j > 0; j = j >> 1, k++) {
                if (j % 2 == 1) {
                    Pair<String, Object> pair = queryPairs.get(k);
                    keyList += ("_" + pair.getKey() + ":" + pair.getValue());
                }
            }
            if (set) {
                RedisUtils.leftPush(redisTemplate, keyList, id);
            } else {
                RedisUtils.deleteFromList(redisTemplate, keyList, 1, id);
            }
        }
    }

    protected <T extends BaseDO> T getObjectInRedis(String objectKey, T t) {
        return RedisUtils.getObject(redisTemplate, objectKey, t);
    }

    protected List<? extends BaseDO> getObjectListInRedis(BaseQuery query) {
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
            return getObjectListInRedis(idList);
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

    protected List<? extends BaseDO> getObjectListInRedis(List<String> ids) {
        return RedisUtils.getList(redisTemplate, ids);
    }

    protected <T extends BaseDao> String getEntityName(T t) {
        return t.getClass().getSimpleName().replace("DaoImpl", "DO");
    }

    protected <T extends BaseDO> String getBaseListName(T t) {
        return getBaseListName(t.getClass().getSimpleName());
    }

    protected String getBaseListName(String nameDO) {
        return Joiner.on("").join(nameDO, "List");
    }

    protected <T extends BaseDO> String getQueryName(T t) {
        return t.getClass().getName().replace("DO", "Query");
    }

    protected <T extends BaseDao> String getObjectKeyInRedis(T t, long id) {
        return getEntityName(t) + ":" + id;
    }
}
