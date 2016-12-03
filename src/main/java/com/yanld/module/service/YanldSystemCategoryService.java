package com.yanld.module.service;

import com.yanld.module.common.dal.dataobject.model.ShortCut;
import com.yanld.module.common.dal.dataobject.model.TreeBean;

import java.util.List;

/**
 * 描述：无限级分类service
 * 作者：袁伟倩
 * 创建日期：2016-11-16/11/27.
 */
public interface YanldSystemCategoryService {

    /**
     * 描述：无限级分类－获取节点信息
     * 作者：袁伟倩
     * 创建日期：2016-12-02/18/03.
     */
    List<ShortCut> selectSystemCategorys();

    /**
     * 描述：无限级分类－获取treelist
     * 作者：袁伟倩
     * 创建日期：2016-12-02/18/03.
     */
    List<TreeBean> getSystemCategorys(List<ShortCut> systemMenu);
}
