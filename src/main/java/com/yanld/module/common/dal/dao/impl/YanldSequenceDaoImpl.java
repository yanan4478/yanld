package com.yanld.module.common.dal.dao.impl;

import com.yanld.module.common.dal.dao.YanldSequenceDao;
import com.yanld.module.common.dal.dataobject.YanldSequenceDO;
import com.yanld.module.common.dal.mapper.YanldSequenceMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by yanan on 16/6/27.
 */
@Repository
public class YanldSequenceDaoImpl implements YanldSequenceDao {
    @Resource
    protected SqlSession sqlSession;
    @Override
    public int updateSequence(YanldSequenceDO yanldSequenceDO) {
        YanldSequenceMapper mapper = sqlSession.getMapper(YanldSequenceMapper.class);
        return mapper.updateSequence(yanldSequenceDO);
    }

    @Override
    public YanldSequenceDO selectSequence(String tableName) {
        YanldSequenceMapper mapper = sqlSession.getMapper(YanldSequenceMapper.class);
        return mapper.selectSequence(tableName);
    }
}
