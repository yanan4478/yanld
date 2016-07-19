package com.yanld.module.common.dal.dataobject;

/**
 * Created by yanan on 16/6/28.
 */
public class YanldArticleDO extends BaseDO {
    private String articleTitle;
    private String articleContent;
    private long userId;
    private long articleReadNum;
    private String articleCoverImage;

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getArticleReadNum() {
        return articleReadNum;
    }

    public void setArticleReadNum(long articleReadNum) {
        this.articleReadNum = articleReadNum;
    }

    public String getArticleCoverImage() {
        return articleCoverImage;
    }

    public void setArticleCoverImage(String articleCoverImage) {
        this.articleCoverImage = articleCoverImage;
    }
}
