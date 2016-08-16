package com.yanld.module.common.dal.dao;

import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;

/**
 * Created by yanan on 16/7/8.
 */
public abstract class AbstractDao {
    @Resource
    protected SqlSession sqlSession;

}
