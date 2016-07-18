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
    public long insertUser() {
        YanldUserMapper mapper = sqlSession.getMapper(YanldUserMapper.class);
        return mapper.insertUser();
    }

    @Override
    public int deleteUser() {
        YanldUserMapper mapper = sqlSession.getMapper(YanldUserMapper.class);
        return mapper.deleteUser();
    }

    @Override
    public int logicDeleteUser() {
        YanldUserMapper mapper = sqlSession.getMapper(YanldUserMapper.class);
        return mapper.logicDeleteUser();
    }

    @Override
    public int updateUser() {
        YanldUserMapper mapper = sqlSession.getMapper(YanldUserMapper.class);
        return mapper.updateUser();
    }

    @Override
    public YanldUserDO selectUser() {
        YanldUserMapper mapper = sqlSession.getMapper(YanldUserMapper.class);
        return mapper.selectUser();
    }

    @Override
    public List<YanldUserDO> selectUsers() {
        YanldUserMapper mapper = sqlSession.getMapper(YanldUserMapper.class);
        return mapper.selectUsers();
    }
//    @Override
//    public List<YanldUserDO> queryAllYanldUser() {
////        String s = redisTemplate.execute(new RedisCallback<String>() {
////            @Override
////            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
////                return redisConnection.ping();
////            }
////        });
//
//        YanldUserMapper mapper = sqlSession.getMapper(YanldUserMapper.class);
//        return mapper.queryAllYanldUser();
//    }
}
