package com.yanld.module.dal.dao.impl;

import com.yanld.module.dal.dao.AbstractDao;
import com.yanld.module.dal.dao.YanldUserDao;
import com.yanld.module.dal.dataobject.YanldUserDO;
import com.yanld.module.dal.mapper.YanldUserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;

import java.util.List;

/**
 * Created by yanan on 16/6/27.
 */
public class YanldUserDaoImpl extends AbstractDao implements YanldUserDao
{
    @Override
    public List<YanldUserDO> queryAllYanldUser() {
//        String s = redisTemplate.execute(new RedisCallback<String>() {
//            @Override
//            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                return redisConnection.ping();
//            }
//        });

        YanldUserMapper mapper = sqlSession.getMapper(YanldUserMapper.class);
        return mapper.queryAllYanldUser();
    }
}
