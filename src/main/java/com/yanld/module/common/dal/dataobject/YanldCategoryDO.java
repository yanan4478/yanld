package com.yanld.module.common.dal.dataobject;

import java.util.Date;
import java.util.List;

/**
 * Created by yanan on 16/7/18.
 */
public class YanldCategoryDO extends BaseDO {
    private String categoryName;
    private long id;
    private short isDeleted;
    private Date createTime;
    private Date modifyTime;

    private List<YanldCategoryMediaRelDO> yanldCategoryMediaRelDOs;

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


    public List<YanldCategoryMediaRelDO> getYanldCategoryMediaRelDOs() {
        return yanldCategoryMediaRelDOs;
    }

    public void setYanldCategoryMediaRelDOs(List<YanldCategoryMediaRelDO> yanldCategoryMediaRelDOs) {
        this.yanldCategoryMediaRelDOs = yanldCategoryMediaRelDOs;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "YanldCategoryDO{" +
                "categoryName='" + categoryName + '\'' +
                ", id=" + id +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", yanldCategoryMediaRelDOs=" + yanldCategoryMediaRelDOs +
                '}';
    }
}
