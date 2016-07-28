package com.yanld.module.service.impl;

import com.yanld.module.bo.YanldCategoryBO;
import com.yanld.module.bo.YanldIndexArticleBO;
import com.yanld.module.bo.YanldIndexBO;
import com.yanld.module.common.constant.BaseConstant;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.common.dal.dataobject.YanldCategoryDO;
import com.yanld.module.common.dal.dataobject.YanldCategoryMediaRelDO;
import com.yanld.module.common.dal.dataobject.YanldUserDO;
import com.yanld.module.common.dal.query.YanldCategoryMediaRelQuery;
import com.yanld.module.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanan on 16/7/18.
 */
@Service
public class YanldIndexServiceImpl extends BaseService implements YanldIndexService {
    @Resource
    private YanldCategoryService categoryService;
    @Resource
    private YanldCategoryMediaRelService categoryMediaRelService;
    @Resource
    private YanldArticleService articleService;
    @Resource
    private YanldUserService userService;

    @Override
    public YanldIndexBO getIndexBO(int category, int page) {
        YanldIndexBO yanldIndexBO = new YanldIndexBO();
        List<YanldCategoryBO> categoryBOs = getCategories();
        List<YanldIndexArticleBO> indexArticleBOs = getIndexArticles(category, page);
        yanldIndexBO.setCategoryBOs(categoryBOs);
        yanldIndexBO.setIndexArticleBOs(indexArticleBOs);
        return yanldIndexBO;
    }

    private List<YanldCategoryBO> getCategories() {
        List<YanldCategoryBO> categoryBOs = new ArrayList<>();
        List<YanldCategoryDO> categoryDOs = categoryService.selectCategories();
        for(YanldCategoryDO categoryDO : categoryDOs) {
            YanldCategoryBO categoryBO = new YanldCategoryBO();
            categoryBO.setCategoryName(categoryDO.getCategoryName());
            categoryBO.setCategoryLink("/" + categoryDO.getId() + "-1");
            categoryBOs.add(categoryBO);
        }
        return categoryBOs;
    }

    private List<YanldIndexArticleBO> getIndexArticles(long category, int page) {
        List<YanldIndexArticleBO> indexArticleBOs = new ArrayList<>();
        YanldCategoryMediaRelQuery relQuery = new YanldCategoryMediaRelQuery();
        relQuery.setCategoryId(category);
        relQuery.setLimit(BaseConstant.RECORDS_PERPAGE);
        relQuery.setOffset((page - 1) * BaseConstant.RECORDS_PERPAGE);
        List<YanldCategoryMediaRelDO> categoryMediaRelDOs = categoryMediaRelService.selectCategoryMediaRels(relQuery);
        List<Long> articleIds = new ArrayList<>();
        for(YanldCategoryMediaRelDO categoryMediaRelDO : categoryMediaRelDOs) {
            articleIds.add(categoryMediaRelDO.getMediaId());
        }
        List<YanldArticleDO> articleDOs = articleService.selectArticlesByIds(articleIds);
        for(YanldArticleDO articleDO : articleDOs) {
            YanldIndexArticleBO articleBO = new YanldIndexArticleBO();
            articleBO.setId(articleDO.getId());
            articleBO.setArticleTitle(articleDO.getArticleTitle());
            articleBO.setReadNum(articleDO.getArticleReadNum());
            articleBO.setThumbImage(articleDO.getArticleCoverImage());
            YanldUserDO userDO = userService.selectUser(articleDO.getUserId());
            articleBO.setAuthorName(userDO.getUserName());
            indexArticleBOs.add(articleBO);
        }
        return indexArticleBOs;
    }
}
