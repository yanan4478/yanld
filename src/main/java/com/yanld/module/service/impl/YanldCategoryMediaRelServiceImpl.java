package com.yanld.module.service.impl;

import com.yanld.module.dal.dao.YanldCategoryMediaRelDao;
import com.yanld.module.dal.dataobject.YanldCategoryMediaRelDO;
import com.yanld.module.dal.query.YanldCategoryMediaRelQuery;
import com.yanld.module.service.YanldCategoryMediaRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yanan on 16/6/28.
 */
@Service
public class YanldCategoryMediaRelServiceImpl implements YanldCategoryMediaRelService {

    @Resource
    private YanldCategoryMediaRelDao yanldCategoryMediaRelDao;

    @Override
    public long insertCategoryMediaRel() {
        return yanldCategoryMediaRelDao.insertCategoryMediaRel();
    }

    @Override
    public int deleteCategoryMediaRel() {
        return yanldCategoryMediaRelDao.deleteCategoryMediaRel();
    }

    @Override
    public int logicDeleteCategoryMediaRel() {
        return yanldCategoryMediaRelDao.logicDeleteCategoryMediaRel();
    }

    @Override
    public int updateCategoryMediaRel() {
        return yanldCategoryMediaRelDao.updateCategoryMediaRel();
    }

    @Override
    public YanldCategoryMediaRelDO selectCategoryMediaRel() {
        return yanldCategoryMediaRelDao.selectCategoryMediaRel();
    }

    @Override
    public List<YanldCategoryMediaRelDO> selectCategoryMediaRels(YanldCategoryMediaRelQuery query) {
        return yanldCategoryMediaRelDao.selectCategoryMediaRels(query);
    }
}
