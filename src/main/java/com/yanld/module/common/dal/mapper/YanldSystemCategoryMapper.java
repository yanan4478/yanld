package com.yanld.module.common.dal.mapper;

import com.yanld.module.common.dal.dataobject.YanldSystemCategoryDO;
import com.yanld.module.common.dal.dataobject.model.ShortCut;

import java.util.List;

/**
 * 描述：无限级分类mapper
 * 作者：袁伟倩
 * 创建日期：2016-11-16/11/27.
 */
public interface YanldSystemCategoryMapper {
    /**
     * 描述：无限级分类－获取节点信息
     * 作者：袁伟倩
     * 创建日期：2016-11-16/11/27.
     */
    List<ShortCut> selectSystemCategorys();

}
