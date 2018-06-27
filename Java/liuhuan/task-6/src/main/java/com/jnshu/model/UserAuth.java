package com.jnshu.model;

/**
 * @program: taskTwo
 * @description: 账号认证 Cookie
 * @author: Mr.xweiba
 * @create: 2018-05-21 15:54
 **/

public class UserAuth {
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
