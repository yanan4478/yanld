package com.yanld.module.common.dal.dataobject;

/**
 * Created by yanan on 16/6/28.
 */
public class YanldCategoryMediaRelDO extends BaseDO {
    private long categoryId;
    private long mediaId;
    private int mediaType;

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

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }
}
