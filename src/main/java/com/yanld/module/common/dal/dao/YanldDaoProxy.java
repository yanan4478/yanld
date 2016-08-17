package com.yanld.module.common.dal.dao;

/**
 * Created by yanan on 16/8/14.
 */
public interface YanldDaoProxy {
    <P, R> R invoke(BaseDao dao, P param, Class<R> resultClazz) throws Exception;
}
