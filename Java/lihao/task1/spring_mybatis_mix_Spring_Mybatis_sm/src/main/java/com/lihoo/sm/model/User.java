package com.lihoo.sm.model;

import java.io.Serializable;

/**
 * @author lihoo
 * @Title: User
 * @ProjectName spring_mybatis_1
 * @Description: TODO
 * @date 2018/8/2-18:24
 */


public class User implements Serializable {
    private int id;
    private String username;
    private int qq;
    private String job;
    private String school;
    private String url;


    public User() {}

    public User(int id, String username, int qq, String job, String school, String url) {
        this.id = id;
        this.username = username;
        this.qq = qq;
        this.job = job;
        this.school = school;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", qq=" + qq +
                ", job='" + job + '\'' +
                ", school='" + school + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
