package com.jnshu.model;

import java.io.Serializable;

/* session登陆验证 已废弃 */
/* 登陆 */
public class Auth implements Serializable{
    //登陆用户名
    private String username;
    //登陆密码
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
