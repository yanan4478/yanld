package com.yanld.module.common.dal.dao;

import com.yanld.module.common.dal.dataobject.BaseDO;
import com.yanld.module.common.util.RedisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by yanan on 16/7/8.
 */
public abstract class BaseDao {
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

    protected int deleteObjectInRedis(String key) {
        return RedisUtils.delete(redisTemplate, key);
    }

    protected <T extends BaseDO> T getObjectInRedis(String objectKey, T t) {
        return RedisUtils.getObject(redisTemplate, objectKey, t);
    }

    protected <T extends BaseDao> String getEntityName(T t) {
        return t.getClass().getSimpleName().replace("DaoImpl", "DO");
    }

    protected <T extends BaseDao> String getObjectKeyInRedis(T t, long id) {
        return getEntityName(t) + ":" + id;
    }
}
