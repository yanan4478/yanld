package com.yanld.module.service;

import com.yanld.module.dal.dataobject.YanldCategoryDO;

import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
public interface YanldCategoryService {
    long insertCategory();

    int deleteCategory();

    int logicDeleteCategory();

    int updateCategory();

    YanldCategoryDO selectCategory();

    List<YanldCategoryDO> selectCategories();
}
