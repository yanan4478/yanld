package com.yanld.module.common.dal.dao;

/**
 * Created by yanan on 16/8/14.
 */
public interface YanldDaoProxy {
    <T, E> E invoke(BaseDao dao, T param, Class<E> resultClazz) throws Exception;
}
