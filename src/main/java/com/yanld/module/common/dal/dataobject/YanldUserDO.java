package com.yanld.module.common.dal.dataobject;

import java.util.Date;

/**
 * Created by yanan on 16/6/28.
 */
public class YanldUserDO extends BaseDO {
    private String userName;
    private String userPassword;
    private Date lastLoginTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
