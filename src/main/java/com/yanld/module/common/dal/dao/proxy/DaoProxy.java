package com.yanld.module.common.dal.dao.proxy;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.yanld.module.common.annotation.OperateInRedis;
import com.yanld.module.common.constant.BaseConstant;
import com.yanld.module.common.constant.DaoOptEnum;
import com.yanld.module.common.dal.dao.BaseDao;
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

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanan on 16/8/17.
 */
public class DaoProxy implements InvocationHandler {
    private static final Logger logger = LoggerFactory.getLogger(InvocationHandler.class);

    private BaseDao dao;

    private RedisTemplate<Serializable, Serializable> redisTemplate;

    public DaoProxy(BaseDao dao, RedisTemplate<Serializable, Serializable> redisTemplate) {
        this.dao = dao;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method = dao.getClass().getMethod(method.getName(), method.getParameterTypes());
        String methodName = method.getName();
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
        Object result = null;
        switch (opt) {
            case INSERT:
                result = doInsert(dao, method, args);
                break;
            case LOGIC_DELETE:
                result = doLogicDelete(dao, method, args);
                break;
            case DELETE:
                result = doDelete(dao, method, args);
                break;
            case UPDATE:
                result = doUpdate(dao, method, args);
                break;
            case SELECT:
                result = doSelect(dao, method, args);
                break;
            case SELECT_IDS:
                result = doSelectIds(dao, method, args);
                break;
            case SELECT_QUERY:
                result = doSelectQuery(dao, method, args);
                break;
            case SELECT_COUNT:
                result = doSelectCount(dao, method, args);
                break;
            default:
        }
        return result;
    }

    private Long doInsert(BaseDao dao, Method method, Object[] args) throws Exception {
        Long result = (Long) method.invoke(dao, args);
        if (method.isAnnotationPresent(OperateInRedis.class) && result > 0) {
            setObjectToRedisWithList((BaseDO) args[0]);
        }
        return result;
    }

    private Long doLogicDelete(BaseDao dao, Method method, Object[] args) throws Exception {
        Long result = (Long) method.invoke(dao, args);
        if (method.isAnnotationPresent(OperateInRedis.class) && result > 0) {
            String dtoName = MessageFormat.format(BaseConstant.YANLD_DO_TEMPLATE, method.getName().replace("logicDelete", ""));
            Class<?> clazz = Class.forName(dtoName);
            BaseDO baseDO = (BaseDO) clazz.newInstance();
            baseDO = getObjectInRedis(getObjectKeyInRedis(dao, (long) args[0]), baseDO);
            deleteObjectInRedis(baseDO);
        }
        return result;
    }

    private Long doDelete(BaseDao dao, Method method, Object[] args) throws Exception {
        Long result = (Long) method.invoke(dao, args);
        if (method.isAnnotationPresent(OperateInRedis.class) && result > 0) {
            String dtoName = MessageFormat.format(BaseConstant.YANLD_DO_TEMPLATE, method.getName().replace("delete", ""));
            Class<?> clazz = Class.forName(dtoName);
            BaseDO baseDO = (BaseDO) clazz.newInstance();
            baseDO = getObjectInRedis(getObjectKeyInRedis(dao, (long) args[0]), baseDO);
            deleteObjectInRedis(baseDO);
        }
        return result;
    }

    private Long doUpdate(BaseDao dao, Method method, Object[] args) throws Exception {
        Long result = (Long) method.invoke(dao, args);
        if (method.isAnnotationPresent(OperateInRedis.class) && result > 0) {
            setObjectToRedis((BaseDO) args[0]);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private Object doSelect(BaseDao dao, Method method, Object[] args) throws Exception {
        boolean operateInRedis = method.isAnnotationPresent(OperateInRedis.class);
        if (operateInRedis) {
            BaseDO dto = getObjectInRedis(getObjectKeyInRedis(dao, (Long) args[0]), (BaseDO) method.getReturnType().newInstance());
            if (dto != null) {
                return dto;
            }
        }
        Object result =  method.invoke(dao, (long) args[0]);
        if (operateInRedis) {
            if (result != null) {
                setObjectToRedis((BaseDO) result);
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private List doSelectIds(BaseDao dao, Method method, Object[] args) throws Exception {
        List<String> param = (List<String>) args[0];
        if (param.isEmpty()) {
            return Lists.newArrayList();
        }
        if (method.isAnnotationPresent(OperateInRedis.class)) {
            String dtoName = MessageFormat.format(BaseConstant.YANLD_DO_TEMPLATE, method.getName().replaceAll("select|sByIds", ""));
            Class<?> clazz = Class.forName(dtoName);
            BaseDO baseDO = (BaseDO) clazz.newInstance();
            List<BaseDO> baseDOs = getObjectListInRedis(toRedisIds(param, baseDO), baseDO);
            if (!DataUtils.isBlank(baseDOs)) {
                return baseDOs;
            }
        }
        return (List) method.invoke(dao, param);
    }

    @SuppressWarnings("unchecked")
    private Object doSelectQuery(BaseDao dao, Method method, Object[] args) throws Exception {
        if (method.isAnnotationPresent(OperateInRedis.class)) {
            String dtoName = MessageFormat.format(BaseConstant.YANLD_DO_TEMPLATE, method.getName().replaceAll("select|Query", ""));
            Class<?> clazz = Class.forName(dtoName);
            BaseDO baseDO = (BaseDO) clazz.newInstance();
            List<BaseDO> baseDOs = getObjectListInRedis((BaseQuery) args[0], baseDO);
            if (!DataUtils.isBlank(baseDOs)) {
                return baseDOs;
            }
        }
        return method.invoke(dao, (BaseQuery) args[0]);
    }

    private Long doSelectCount(BaseDao dao, Method method, Object[] args) throws Exception {
        if (method.isAnnotationPresent(OperateInRedis.class)) {
            long count = getObjectCount((BaseQuery) args[0]);
            if (count != 0) {
                return count;
            }
        }
        return (Long) method.invoke(dao, (BaseQuery) args[0]);
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
        if(dto == null) {
            return 0;
        }
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