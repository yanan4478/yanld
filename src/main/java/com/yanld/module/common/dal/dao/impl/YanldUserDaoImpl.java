package com.yanld.module.common.dal.dao.impl;

import com.yanld.module.common.annotation.OperateInRedis;
import com.yanld.module.common.dal.dao.AbstractDao;
import com.yanld.module.common.dal.dao.YanldUserDao;
import com.yanld.module.common.dal.dataobject.YanldUserDO;
import com.yanld.module.common.dal.dataobject.YanldUserDO;
import com.yanld.module.common.dal.mapper.YanldUserMapper;
import com.yanld.module.common.dal.mapper.YanldUserMapper;
import com.yanld.module.common.dal.query.YanldUserQuery;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanan on 16/6/27.
 */
@Repository
public class YanldUserDaoImpl extends AbstractDao implements YanldUserDao {
    @Override
    @OperateInRedis
    public Long insertUser(YanldUserDO yanldUserDO) {
        sqlSession.getMapper(YanldUserMapper.class).insertUser(yanldUserDO);
        return yanldUserDO.getId();
    }

    @Override
    @OperateInRedis
    public Long deleteUser(Long id) {
        return sqlSession.getMapper(YanldUserMapper.class).deleteUser(id);
    }

    @Override
    @OperateInRedis
    public Long logicDeleteUser(Long id) {
        return sqlSession.getMapper(YanldUserMapper.class).logicDeleteUser(id);
    }

    @Override
    @OperateInRedis
    public Long updateUser(YanldUserDO yanldUserDO) {
        return sqlSession.getMapper(YanldUserMapper.class).updateUser(yanldUserDO);
    }

    @Override
    @OperateInRedis
    public YanldUserDO selectUser(Long id) {
        return sqlSession.getMapper(YanldUserMapper.class).selectUser(id);
    }

    @Override
    @OperateInRedis
    public List<YanldUserDO> selectUsersByIds(List<Long> ids) {
        YanldUserMapper mapper = sqlSession.getMapper(YanldUserMapper.class);
        Map<String, List<Long>> idsMap = new HashMap<>();
        idsMap.put("ids", ids);
        return mapper.selectUsersByIds(idsMap);
    }

    @Override
    @OperateInRedis
    public List<YanldUserDO> selectUserQuery(YanldUserQuery query) {
        return sqlSession.getMapper(YanldUserMapper.class).selectUsers(query);
    }

    @Override
    @OperateInRedis
    public Long selectUserCount(YanldUserQuery query) {
        return sqlSession.getMapper(YanldUserMapper.class).selectUserCount(query);
    }
}
