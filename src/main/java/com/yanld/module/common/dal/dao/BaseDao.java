package com.yanld.module.common.dal.dao;

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

    //public
}
