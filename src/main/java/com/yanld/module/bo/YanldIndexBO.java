package com.yanld.module.bo;

import java.util.List;

/**
 * Created by yanan on 16/7/18.
 */
public class YanldIndexBO {
    private List<YanldCategoryBO> categoryBOs;
    private List<YanldIndexArticleBO> indexArticleBOs;

    public List<YanldCategoryBO> getCategoryBOs() {
        return categoryBOs;
    }

    public void setCategoryBOs(List<YanldCategoryBO> categoryBOs) {
        this.categoryBOs = categoryBOs;
    }

    public List<YanldIndexArticleBO> getIndexArticleBOs() {
        return indexArticleBOs;
    }

    public void setIndexArticleBOs(List<YanldIndexArticleBO> indexArticleBOs) {
        this.indexArticleBOs = indexArticleBOs;
    }
}
