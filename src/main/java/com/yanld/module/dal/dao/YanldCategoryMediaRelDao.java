package com.yanld.module.dal.dao;

import com.yanld.module.dal.dataobject.YanldCategoryMediaRelDO;
import com.yanld.module.dal.query.YanldCategoryMediaRelQuery;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldCategoryMediaRelDao {
    long insertCategoryMediaRel();

    int deleteCategoryMediaRel();

    int logicDeleteCategoryMediaRel();

    int updateCategoryMediaRel();

    YanldCategoryMediaRelDO selectCategoryMediaRel();

    List<YanldCategoryMediaRelDO> selectCategoryMediaRels(YanldCategoryMediaRelQuery query);
}
