package com.yanld.module.bo;

/**
 * Created by yanan on 16/7/19.
 */
public class YanldDetailArticleBO {
    private String createTime;
    private String articleTitle;
    private String articleContent;
    private String authorName;
    private long readNum;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public long getReadNum() {
        return readNum;
    }

    public void setReadNum(long readNum) {
        this.readNum = readNum;
    }
}
