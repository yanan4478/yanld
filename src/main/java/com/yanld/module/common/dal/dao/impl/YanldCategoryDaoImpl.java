package com.yanld.module.common.dal.dao.impl;

import com.yanld.module.common.dal.dao.YanldCategoryDao;
import com.yanld.module.common.dal.mapper.YanldCategoryMapper;
import com.yanld.module.common.dal.dao.AbstractDao;
import com.yanld.module.common.dal.dataobject.YanldCategoryDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yanan on 16/7/18.
 */
@Repository
public class YanldCategoryDaoImpl extends AbstractDao implements YanldCategoryDao {
    @Override
    public long insertCategory() {
        YanldCategoryMapper mapper = sqlSession.getMapper(YanldCategoryMapper.class);
        return mapper.insertCategory();
    }

    @Override
    public int deleteCategory() {
        YanldCategoryMapper mapper = sqlSession.getMapper(YanldCategoryMapper.class);
        return mapper.deleteCategory();
    }

    @Override
    public int logicDeleteCategory() {
        YanldCategoryMapper mapper = sqlSession.getMapper(YanldCategoryMapper.class);
        return mapper.logicDeleteCategory();
    }

    @Override
    public int updateCategory() {
        YanldCategoryMapper mapper = sqlSession.getMapper(YanldCategoryMapper.class);
        return mapper.updateCategory();
    }

    @Override
    public YanldCategoryDO selectCategory() {
        YanldCategoryMapper mapper = sqlSession.getMapper(YanldCategoryMapper.class);
        return mapper.selectCategory();
    }

    @Override
    public List<YanldCategoryDO> selectCategories() {
        YanldCategoryMapper mapper = sqlSession.getMapper(YanldCategoryMapper.class);
        return mapper.selectCategories();
    }
}
