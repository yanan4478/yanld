package com.yanld.module.dal.mapper;

import com.yanld.module.dal.dataobject.YanldCategoryMediaRelDO;

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

    List<YanldCategoryMediaRelDO> selectCategoryMediaRels();
}
