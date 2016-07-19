package com.yanld.module.service.impl;

import com.yanld.module.common.dal.dao.YanldCategoryDao;
import com.yanld.module.common.dal.dataobject.YanldCategoryDO;
import com.yanld.module.service.YanldCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yanan on 16/7/18.
 */
@Service
public class YanldCategoryServiceImpl implements YanldCategoryService {
    @Resource
    YanldCategoryDao yanldCategoryDao;

    @Override
    public long insertCategory() {
        return yanldCategoryDao.insertCategory();
    }

    @Override
    public int deleteCategory() {
        return yanldCategoryDao.deleteCategory();
    }

    @Override
    public int logicDeleteCategory() {
        return yanldCategoryDao.logicDeleteCategory();
    }

    @Override
    public int updateCategory() {
        return yanldCategoryDao.updateCategory();
    }

    @Override
    public YanldCategoryDO selectCategory() {
        return yanldCategoryDao.selectCategory();
    }

    @Override
    public List<YanldCategoryDO> selectCategories() {
        return yanldCategoryDao.selectCategories();
    }
}
