package com.yanld.module.common.dal.dao.impl;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.yanld.module.common.annotation.OperateInRedis;
import com.yanld.module.common.constant.BaseConstant;
import com.yanld.module.common.constant.DaoOptEnum;
import com.yanld.module.common.dal.dao.BaseDao;
import com.yanld.module.common.dal.dao.YanldDaoProxy;
import com.yanld.module.common.dal.dataobject.BaseDO;
import com.yanld.module.common.dal.query.BaseQuery;
import com.yanld.module.common.exception.DaoMethodNotExistException;
import com.yanld.module.common.util.DataUtils;
import com.yanld.module.common.util.RedisUtils;
import com.yanld.module.common.util.StackTraceUtils;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanan on 16/8/14.
 */
public class YanldDaoProxyImpl implements YanldDaoProxy {
    private static final Logger logger = LoggerFactory.getLogger(YanldDaoProxyImpl.class);

    @Resource
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    @SuppressWarnings("unchecked")
    public <P, R> R invoke(BaseDao dao, P param, Class<R> resultClazz) throws Exception {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        DaoOptEnum opt = null;
        for (DaoOptEnum optEnum : DaoOptEnum.values()) {
            if (methodName.matches(optEnum.getReg())) {
                opt = optEnum;
                break;
            }
        }
        if (opt == null) {
            throw new DaoMethodNotExistException("the dao method " + methodName + "is not exist!!");
        }
        R result = null;
        switch (opt) {
            case INSERT:
                result = (R) doInsert(dao, methodName, param);
                break;
            case LOGIC_DELETE:
                result = (R) doLogicDelete(dao, methodName, (Long) param);
                break;
            case DELETE:
                result = (R) doDelete(dao, methodName, (Long) param);
                break;
            case UPDATE:
                result = (R) doUpdate(dao, methodName, param);
                break;
            case SELECT:
                result = doSelect(dao, methodName, (Long) param, resultClazz);
                break;
            case SELECT_IDS:
                result = doSelectIds(dao, methodName, (List<Long>) param);
                break;
            case SELECT_QUERY:
                result = doSelectQuery(dao, methodName, (BaseQuery) param);
                break;
            case SELECT_COUNT:
                result = (R) doSelectCount(dao, methodName, param);
                break;
            default:
        }
        return result;
    }

    private <P> Long doInsert(BaseDao dao, String methodName, P param) throws Exception {
        Method method = dao.getClass().getDeclaredMethod(methodName, param.getClass());
        Long result = (Long) method.invoke(dao, param);
        if (method.isAnnotationPresent(OperateInRedis.class) && result > 0) {
            setObjectToRedisWithList((BaseDO) param);
        }
        return result;
    }

    private Long doLogicDelete(BaseDao dao, String methodName, Long param) throws Exception {
        Method method = dao.getClass().getDeclaredMethod(methodName, param.getClass());
        Long result = (Long) method.invoke(dao, param);
        if (method.isAnnotationPresent(OperateInRedis.class) && result > 0) {
            String dtoName = MessageFormat.format(BaseConstant.YANLD_DO_TEMPLATE, methodName.replace("logicDelete", ""));
            Class<?> clazz = Class.forName(dtoName);
            BaseDO baseDO = (BaseDO) clazz.newInstance();
            baseDO = getObjectInRedis(getObjectKeyInRedis(dao, param), baseDO);
            deleteObjectInRedis(baseDO);
        }
        return result;
    }

    private Long doDelete(BaseDao dao, String methodName, Long param) throws Exception {
        Method method = dao.getClass().getDeclaredMethod(methodName, param.getClass());
        Long result = (Long) method.invoke(dao, param);
        if (method.isAnnotationPresent(OperateInRedis.class) && result > 0) {
            String dtoName = MessageFormat.format(BaseConstant.YANLD_DO_TEMPLATE, methodName.replace("delete", ""));
            Class<?> clazz = Class.forName(dtoName);
            BaseDO baseDO = (BaseDO) clazz.newInstance();
            baseDO = getObjectInRedis(getObjectKeyInRedis(dao, param), baseDO);
            deleteObjectInRedis(baseDO);
        }
        return result;
    }

    private <P> Long doUpdate(BaseDao dao, String methodName, P param) throws Exception {
        Method method = dao.getClass().getDeclaredMethod(methodName, param.getClass());
        Long result = (Long) method.invoke(dao, param);
        if (method.isAnnotationPresent(OperateInRedis.class) && result > 0) {
            setObjectToRedis((BaseDO) param);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private <R> R doSelect(BaseDao dao, String methodName, Long param, Class<R> resultClazz) throws Exception {
        Method method = dao.getClass().getDeclaredMethod(methodName, param.getClass());
        boolean operateInRedis = method.isAnnotationPresent(OperateInRedis.class);
        if (operateInRedis) {
            BaseDO dto = getObjectInRedis(getObjectKeyInRedis(dao, param), (BaseDO) resultClazz.newInstance());
            if (dto != null) {
                return (R) dto;
            }
        }
        R result = (R) method.invoke(dao, param);
        if (operateInRedis) {
            if (result != null) {
                setObjectToRedis((BaseDO) result);
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private <R> R doSelectIds(BaseDao dao, String methodName, List<Long> param) throws Exception {
        if (param.isEmpty()) {
            return (R) Lists.newArrayList();
        }
        Method method = dao.getClass().getDeclaredMethod(methodName, List.class);
        if (method.isAnnotationPresent(OperateInRedis.class)) {
            String dtoName = MessageFormat.format(BaseConstant.YANLD_DO_TEMPLATE, methodName.replaceAll("select|sByIds", ""));
            Class<?> clazz = Class.forName(dtoName);
            BaseDO baseDO = (BaseDO) clazz.newInstance();
            List<BaseDO> baseDOs = getObjectListInRedis(toRedisIds(param, baseDO), baseDO);
            if (!DataUtils.isBlank(baseDOs)) {
                return (R) baseDOs;
            }
        }
        return (R) method.invoke(dao, param);
    }

    @SuppressWarnings("unchecked")
    private <R> R doSelectQuery(BaseDao dao, String methodName, BaseQuery param) throws Exception {
        String queryName = MessageFormat.format(BaseConstant.YANLD_QUERY_TEMPLATE, methodName.replaceAll("select|Query", ""));
        Method method = dao.getClass().getDeclaredMethod(methodName, Class.forName(queryName));
        if (method.isAnnotationPresent(OperateInRedis.class)) {
            String dtoName = MessageFormat.format(BaseConstant.YANLD_DO_TEMPLATE, methodName.replaceAll("select|Query", ""));
            Class<?> clazz = Class.forName(dtoName);
            BaseDO baseDO = (BaseDO) clazz.newInstance();
            List<BaseDO> baseDOs = getObjectListInRedis(param, baseDO);
            if (!DataUtils.isBlank(baseDOs)) {
                return (R) baseDOs;
            }
        }
        return (R) method.invoke(dao, param);
    }

    private <P> Long doSelectCount(BaseDao dao, String methodName, P param) throws Exception {
        Method method = dao.getClass().getDeclaredMethod(methodName, param.getClass());
        if (method.isAnnotationPresent(OperateInRedis.class)) {
            long count = getObjectCount((BaseQuery) param);
            if (count != 0) {
                return count;
            }
        }
        return (Long) method.invoke(dao, param);
    }

    private <T extends BaseDO> int setObjectToRedis(String objectKey, T dto) {
        return RedisUtils.setObject(redisTemplate, objectKey, dto);
    }

    private <T extends BaseDO> int setObjectToRedis(T dto) {
        return setObjectToRedis(dto.getClass().getSimpleName() + ":" + dto.getId(), dto);
    }

    private <T extends BaseDO> int setObjectToRedisWithList(String objectKey, T dto) {
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

    private <T extends BaseDO> int setObjectToRedisWithList(T dto) {
        return setObjectToRedisWithList(dto.getClass().getSimpleName() + ":" + dto.getId(), dto);
    }

    private int deleteObjectInRedis(BaseDO dto) {
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
        List<String> listKeys = getListKeys(dto, query);
        for (String listKey : listKeys) {
            if (set) {
                RedisUtils.leftPush(redisTemplate, listKey, String.valueOf(id));
            } else {
                RedisUtils.deleteFromList(redisTemplate, listKey, 1, String.valueOf(id));
            }
        }
    }

    public static <T extends BaseDO, Q extends BaseQuery> List<String> getListKeys(T dto, Q query) throws Exception {
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
        String listKey = getBaseListName(dto);
        List<String> listKeys = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, queryPairs.size()); i++) {
            for (int j = i, k = 0; j > 0; j = j >> 1, k++) {
                if (j % 2 == 1) {
                    Pair<String, Object> pair = queryPairs.get(k);
                    listKey += ("_" + pair.getKey() + ":" + pair.getValue());
                }
            }
            listKeys.add(listKey);
        }
        return listKeys;
    }

    private <T extends BaseDO> T getObjectInRedis(String objectKey, T dto) {
        return RedisUtils.getObject(redisTemplate, objectKey, dto);
    }

    private <T extends BaseDO> List<T> getObjectListInRedis(BaseQuery query, T dto) {
        try {
            String key = getQueryKey(query);
            long start = query.getOffset();
            long end = start + query.getLimit() - 1;
            if (query.getLimit() <= 0) {
                start = 0;
                end = -1;
            }
            List<String> idList = RedisUtils.getList(redisTemplate, key, start, end);
            idList = toRedisIds(idList, dto);
            return getObjectListInRedis(idList, dto);
        } catch (IllegalAccessException e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return Lists.newArrayList();
        }
    }

    private long getObjectCount(BaseQuery query) {
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
            field.setAccessible(true);
            if (field.get(query) != null) {
                key += ("_" + field.getName() + ":" + String.valueOf(field.get(query)));
            }
        }
        return key;
    }

    private <T extends BaseDO> List<T> getObjectListInRedis(List<String> ids, T dto) {
        return RedisUtils.getList(redisTemplate, ids, dto);
    }

    private <T extends BaseDao> String getDtoName(T dao) {
        return dao.getClass().getSimpleName().replace("DaoImpl", "DO");
    }

    private static <T extends BaseDO> String getBaseListName(T dto) {
        return getBaseListName(dto.getClass().getSimpleName());
    }

    private static String getBaseListName(String nameDO) {
        return Joiner.on("").join(nameDO, "List");
    }

    private <T extends BaseDO> String getQueryName(T dto) {
        return dto.getClass().getName().replace("dataobject.YanldArticleDO", "query.YanldArticleQuery");
    }

    private <T extends BaseDao> String getObjectKeyInRedis(T dao, long id) {
        return getDtoName(dao) + ":" + id;
    }

    private <T extends BaseDO> List<String> toRedisIds(List<?> ids, T dto) {
        List<String> resultList = new ArrayList<>();
        String dtoName = dto.getClass().getSimpleName();
        for (Object id : ids) {
            String redisId = Joiner.on("").join(dtoName, ":", id);
            resultList.add(redisId);
        }
        return resultList;
    }
}
