package com.yanld.module.common.util;

import com.google.common.collect.Lists;
import com.yanld.module.common.dal.dataobject.BaseDO;
import com.yanld.module.common.patch.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by yanan on 16/7/20.
 */
public class RedisUtils {

    public static final Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    public static String ping(RedisTemplate<Serializable, Serializable> redisTemplate) {
        try {
            return redisTemplate.execute(new RedisCallback<String>() {
                @Override
                public String doInRedis(RedisConnection connection) throws DataAccessException {
                    return connection.ping();
                }
            });
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return "error";
        }
    }

    public static String getString(RedisTemplate<Serializable, Serializable> redisTemplate,
                                   String key) {
        try {
            return (String) redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return "";
        }
    }

    public static List<String> multiGetString(RedisTemplate<Serializable, Serializable> redisTemplate,
                                              final List<Serializable> keys) {
        try {
            List<String> resultList = new ArrayList<>();
            for (Serializable result : redisTemplate.opsForValue().multiGet(keys)) {
                resultList.add((String) result);
            }
            return resultList;
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return Lists.newArrayList();
        }
    }

    public static int setString(RedisTemplate<Serializable, Serializable> redisTemplate,
                                String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return 1;
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return 0;
        }
    }

    public static int setStringIfAbsent(RedisTemplate<Serializable, Serializable> redisTemplate,
                                        String key, String value) {
        try {
            redisTemplate.opsForValue().setIfAbsent(key, value);
            return 1;
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return 0;
        }
    }

    public static int setObjectField(RedisTemplate<Serializable, Serializable> redisTemplate,
                                     String objKey, String fieldKey, String fieldValue) {
        try {
            redisTemplate.opsForHash().put(objKey, fieldKey, fieldValue);
            return 1;
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return 0;
        }
    }

    public static int setObjectFieldIfAbsent(RedisTemplate<Serializable, Serializable> redisTemplate,
                                             String objKey, String fieldKey, String fieldValue) {
        try {
            redisTemplate.opsForHash().putIfAbsent(objKey, fieldKey, fieldValue);
            return 1;
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return 0;
        }
    }

    public static <T> int setObject(RedisTemplate<Serializable, Serializable> redisTemplate,
                                    String objKey, T t) {
        try {
            Map map = BeanUtils.describe(t);
            map.remove("class");
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                Object key = iterator.next();
                if (map.get(key) == null) {
                    iterator.remove();
                    map.remove(key);
                }
            }
            redisTemplate.opsForHash().putAll(objKey, map);
            return 1;
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return 0;
        }
    }

    public static String getObjectField(RedisTemplate<Serializable, Serializable> redisTemplate,
                                        String objKey, String fieldKey) {
        try {
            return (String) redisTemplate.opsForHash().get(objKey, fieldKey);
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return "";
        }
    }

    public static <T extends BaseDO> T getObject(RedisTemplate<Serializable, Serializable> redisTemplate,
                                                 String objKey, T dto) {
        try {
            List<Object> hashKeys = getHashKeys(dto);
            List<Object> valueList = redisTemplate.opsForHash().multiGet(objKey, hashKeys);
            if (valueList.get(0) == null) {
                return null;
            }
            return getDTO(hashKeys, valueList, dto);
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return null;
        }
    }

    public static int delete(RedisTemplate<Serializable, Serializable> redisTemplate,
                             String key) {
        try {
            redisTemplate.delete(key);
            return 1;
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return 0;
        }
    }

    public static long leftPush(RedisTemplate<Serializable, Serializable> redisTemplate,
                                String key, String value) {
        try {
            return redisTemplate.opsForList().leftPush(key, value);
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return 0;
        }
    }

    public static long deleteFromList(RedisTemplate<Serializable, Serializable> redisTemplate,
                                      String key, long idx, String value) {
        try {
            return redisTemplate.opsForList().remove(key, idx, value);
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return 0;
        }
    }

    public static List<String> getList(RedisTemplate<Serializable, Serializable> redisTemplate,
                                       String key, long start, long end) {
        try {
            List<Serializable> resultList = redisTemplate.opsForList().range(key, start, end);
            String[] resultArray = resultList.toArray(new String[resultList.size()]);
            return Arrays.asList(resultArray);
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return Lists.newArrayList();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseDO> List<T> getList(RedisTemplate<Serializable, Serializable> redisTemplate,
                                                     List<String> objKeys, T dto) {
        try {
            RedisSerializer keySerializer = redisTemplate.getKeySerializer();
            final List<byte[]> rawKeys = new ArrayList<>();
            for (String key : objKeys) {
                byte[] rawKey = keySerializer.serialize(key);
                rawKeys.add(rawKey);
            }

            List<Object> hashKeys = getHashKeys(dto);
            final byte[][] rawHashKeys = new byte[hashKeys.size()][];
            RedisSerializer hashKeySerializer = redisTemplate.getHashKeySerializer();
            int counter = 0;
            for (Object hashKey : hashKeys) {
                rawHashKeys[counter++] = hashKeySerializer.serialize(hashKey);
            }

            List<Object> resultList = redisTemplate.executePipelined(new RedisCallback() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    for (byte[] rawKey : rawKeys) {
                        connection.hMGet(rawKey, rawHashKeys);
                    }
                    return null;
                }
            });

            List<T> dtoList = new ArrayList<>();
            for (Object valueList : resultList) {
                T tempDto = (T) dto.getClass().newInstance();
                T resultDTO = getDTO(hashKeys, (List<Object>) valueList, tempDto);
                dtoList.add(resultDTO);
            }
            return dtoList;
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return Lists.newArrayList();
        }
    }

    private static <T extends BaseDO> List<Object> getHashKeys(T dto) {
        List<Object> hashKeys = new ArrayList<>();
        Field[] fields = dto.getClass().getDeclaredFields();
        Field[] superFields = dto.getClass().getSuperclass().getDeclaredFields();
        for (Field field : fields) {
            hashKeys.add(field.getName());
        }
        for (Field field : superFields) {
            hashKeys.add(field.getName());
        }
        return hashKeys;
    }

    private static <T extends BaseDO> T getDTO(List<Object> hashKeys, List<Object> valueList, T dto) throws Exception {
        Map<Object, Object> map = new HashMap<>();
        for (int i = 0; i < hashKeys.size(); i++) {
            map.put(hashKeys.get(i), valueList.get(i));
        }
        BeanUtils.populate(dto, map);
        return dto;
    }

    public static long getListCount(RedisTemplate<Serializable, Serializable> redisTemplate,
                                    String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            logger.error(StackTraceUtils.getStackTrance(e));
            return 0;
        }
    }
}
