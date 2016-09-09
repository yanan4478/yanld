package com.yanld.module.dto;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by yanan on 16/9/8.
 */
public class YanldUserDTO {
    @NotBlank(message = "用户名不能为空")
    private String uname;
    @NotBlank(message = "密码不能为空")
    private String pwd;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
