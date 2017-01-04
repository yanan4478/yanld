package com.yanld.module.common.dal.dao.impl;

import com.yanld.module.common.dal.dao.AbstractDao;
import com.yanld.module.common.dal.dao.YanldSystemCategoryDao;
import com.yanld.module.common.dal.dataobject.YanldSystemCategoryDO;
import com.yanld.module.common.dal.dataobject.model.ShortCut;
import com.yanld.module.common.dal.mapper.YanldSystemCategoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述：无限级分类daoImpl
 * 作者：袁伟倩
 * 创建日期：2016-11-16/11/27.
 */
@Repository
public class YanldaSystemCategoryDaoImpl extends AbstractDao implements YanldSystemCategoryDao {
    /**
     * 描述：无限级分类-获取节点信息
     * 作者：袁伟倩
     * 创建日期：2016-11-16/12/03.
     */
    @Override
    public List<ShortCut> selectSystemCategories() {
        YanldSystemCategoryMapper mapper = sqlSession.getMapper(YanldSystemCategoryMapper.class);
        return mapper.selectSystemCategorys();
    }
}
