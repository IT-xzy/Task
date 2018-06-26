package com.jnshu.model;

import java.io.Serializable;

/**
 * @program: smsdemo
 * @description: 用户认证
 * @author: Mr.xweiba
 * @create: 2018-05-29 23:06
 **/

public class UserAuth implements Serializable{
    private static final long serialVersionUID = 8546758869773596190L;
    private Integer id;
    private String au_username;
    private String au_password;

    @Override
    public String toString() {
        return "UserAuth{" +
                "id=" + id +
                ", au_username='" + au_username + '\'' +
                ", au_password='" + au_password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAu_username() {
        return au_username;
    }

    public void setAu_username(String au_username) {
        this.au_username = au_username;
    }

    public String getAu_password() {
        return au_password;
    }

    public void setAu_password(String au_password) {
        this.au_password = au_password;
    }
}
