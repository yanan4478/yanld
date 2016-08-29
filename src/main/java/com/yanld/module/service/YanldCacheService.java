package com.yanld.module.service;

/**
 * Created by yanan on 16/8/9.
 */
public interface YanldCacheService {
    String YANLD_CACHE_ARRAY = "Article,User,";

    String YANLD_SELECTLIST_METHOD = "select{0}Query";

    String YANLD_SELECTCOUNT_METHOD = "select{0}Count";

    String YANLD_DAO = "yanld{0}DaoImpl";

    String YANLD_QUERY = "com.yanld.module.common.dal.query.Yanld{0}Query";
}
