package com.yanld.module.bo;

/**
 * Created by yanan on 16/7/18.
 */
public class YanldIndexArticleBO {
    private long id;
    private String articleTitle;
    private String authorName;
    private long readNum;
    private String thumbImage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
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

    public String getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }
}
