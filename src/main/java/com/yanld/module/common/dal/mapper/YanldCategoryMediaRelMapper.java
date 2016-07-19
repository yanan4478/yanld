package com.yanld.module.common.dal.mapper;

import com.yanld.module.common.dal.dataobject.YanldCategoryMediaRelDO;
import com.yanld.module.common.dal.query.YanldCategoryMediaRelQuery;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldCategoryMediaRelMapper {
    long insertCategoryMediaRel();

    int deleteCategoryMediaRel();

    int logicDeleteCategoryMediaRel();

    int updateCategoryMediaRel();

    YanldCategoryMediaRelDO selectCategoryMediaRel();

    List<YanldCategoryMediaRelDO> selectCategoryMediaRels(YanldCategoryMediaRelQuery query);
}
