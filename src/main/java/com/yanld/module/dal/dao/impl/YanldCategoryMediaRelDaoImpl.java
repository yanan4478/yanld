package com.yanld.module.dal.dao.impl;

import com.yanld.module.dal.dao.BaseDao;
import com.yanld.module.dal.dao.YanldCategoryMediaRelDao;
import com.yanld.module.dal.dataobject.YanldCategoryMediaRelDO;
import com.yanld.module.dal.mapper.YanldCategoryMediaRelMapper;
import com.yanld.module.dal.query.YanldCategoryMediaRelQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yanan on 16/6/27.
 */
@Repository
public class YanldCategoryMediaRelDaoImpl extends BaseDao implements YanldCategoryMediaRelDao
{
    @Override
    public long insertCategoryMediaRel() {
        YanldCategoryMediaRelMapper mapper = sqlSession.getMapper(YanldCategoryMediaRelMapper.class);
        return mapper.insertCategoryMediaRel();
    }

    @Override
    public int deleteCategoryMediaRel() {
        YanldCategoryMediaRelMapper mapper = sqlSession.getMapper(YanldCategoryMediaRelMapper.class);
        return mapper.deleteCategoryMediaRel();
    }

    @Override
    public int logicDeleteCategoryMediaRel() {
        YanldCategoryMediaRelMapper mapper = sqlSession.getMapper(YanldCategoryMediaRelMapper.class);
        return mapper.logicDeleteCategoryMediaRel();
    }

    @Override
    public int updateCategoryMediaRel() {
        YanldCategoryMediaRelMapper mapper = sqlSession.getMapper(YanldCategoryMediaRelMapper.class);
        return mapper.updateCategoryMediaRel();
    }

    @Override
    public YanldCategoryMediaRelDO selectCategoryMediaRel() {
        YanldCategoryMediaRelMapper mapper = sqlSession.getMapper(YanldCategoryMediaRelMapper.class);
        return mapper.selectCategoryMediaRel();
    }

    @Override
    public List<YanldCategoryMediaRelDO> selectCategoryMediaRels(YanldCategoryMediaRelQuery query) {
        YanldCategoryMediaRelMapper mapper = sqlSession.getMapper(YanldCategoryMediaRelMapper.class);
        return mapper.selectCategoryMediaRels(query);
    }
}
