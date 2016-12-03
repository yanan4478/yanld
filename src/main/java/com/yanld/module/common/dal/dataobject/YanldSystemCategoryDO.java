package com.yanld.module.common.dal.dataobject;

import java.util.Date;

/**
 * 描述：无限级分类dto
 * 作者：袁伟倩
 * 创建日期：2016-11-16/11/27.
 */
public class YanldSystemCategoryDO extends BaseDO {

    private long categoryId;
    private long mediaId;
    private int mediaType;
    private long id;
    private short isDeleted;
    private Date createTime;
    private Date modifyTime;
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public short getIsDeleted() {
        return isDeleted;
    }


    public void setIsDeleted(short isDeleted) {
        this.isDeleted = isDeleted;
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getModifyTime() {
        return modifyTime;
    }


    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

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

    @Override
    public String toString() {
        return "YanldSystemCategoryDO{" +
                "categoryId=" + categoryId +
                ", mediaId=" + mediaId +
                ", mediaType=" + mediaType +
                ", id=" + id +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
