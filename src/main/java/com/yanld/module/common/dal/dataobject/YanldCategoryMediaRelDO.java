package com.yanld.module.common.dal.dataobject;

import java.util.Date;

/**
 * Created by yanan on 16/6/28.
 */
public class YanldCategoryMediaRelDO extends BaseDO {
    private long categoryId;
    private long mediaId;
    private int mediaType;
    private long id;
    private short isDeleted;
    private Date createTime;
    private Date modifyTime;

    private YanldCategoryDO yanldCategoryDO; // 添加子目录表


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


    public YanldCategoryDO getYanldCategoryDO() {
        return yanldCategoryDO;
    }

    public void setYanldCategoryDO(YanldCategoryDO yanldCategoryDO) {
        this.yanldCategoryDO = yanldCategoryDO;
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

    public String toString() {
        return "YanldCategoryMediaRelDO{" +
                "categoryId=" + categoryId +
                ", mediaId=" + mediaId +
                ", mediaType=" + mediaType +
                ", id=" + id +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", yanldCategoryDO=" + yanldCategoryDO +
                '}';
    }

}
