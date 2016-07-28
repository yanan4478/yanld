package com.yanld.module.common.dal.query;

/**
 * Created by yanan on 16/7/18.
 */
public class YanldCategoryMediaRelQuery extends BaseQuery {
    private Long categoryId;
    private Long mediaId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }
}
