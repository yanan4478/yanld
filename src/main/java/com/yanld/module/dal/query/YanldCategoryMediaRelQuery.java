package com.yanld.module.dal.query;

/**
 * Created by yanan on 16/7/18.
 */
public class YanldCategoryMediaRelQuery extends BaseQuery {
    private long categoryId;
    private long mediaId;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getMediaId() {
        return mediaId;
    }

    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
    }
}
