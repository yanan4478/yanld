package com.yanld.module.dal.dao.impl;

import com.yanld.module.dal.dao.YanldUserDao;
import com.yanld.module.dal.dataobject.YanldUserDO;
import com.yanld.module.dal.mapper.YanldUserMapper;
import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yanan on 16/6/27.
 */
public class YanldUserDaoImpl implements YanldUserDao
{
    @Resource
    SqlSession sqlSession;

    @Override
    public List<YanldUserDO> queryAllYanldUser() {
        YanldUserMapper mapper = sqlSession.getMapper(YanldUserMapper.class);
        return mapper.queryAllYanldUser();
    }
}
