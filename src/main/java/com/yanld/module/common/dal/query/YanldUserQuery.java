package com.yanld.module.common.dal.query;

import com.yanld.module.common.annotation.RedisQuery;
import com.yanld.module.common.constant.RedisQueryLevel;

/**
 * Created by yanan on 16/8/29.
 */
public class YanldUserQuery extends BaseQuery {
    private String userName;
    @RedisQuery(RedisQueryLevel.COMBO)
    private String userPassword;

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
}
