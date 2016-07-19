package com.yanld.module.common.dal.dataobject;

import java.util.Date;

/**
 * Created by yanan on 16/7/18.
 */
public class BaseDO {
    private long id;
    private Date createTime;
    private Date modifyTime;
    private short isDeleted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(short isDeleted) {
        this.isDeleted = isDeleted;
    }
}
