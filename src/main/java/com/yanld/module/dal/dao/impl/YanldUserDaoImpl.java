package com.yanld.module.dal.dao.impl;

import com.yanld.module.dal.dao.BaseDao;
import com.yanld.module.dal.dao.YanldUserDao;
import com.yanld.module.dal.dataobject.YanldUserDO;
import com.yanld.module.dal.mapper.YanldUserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yanan on 16/6/27.
 */
@Repository
public class YanldUserDaoImpl extends BaseDao implements YanldUserDao
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
