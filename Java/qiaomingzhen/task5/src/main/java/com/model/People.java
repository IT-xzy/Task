package com.model;/*
 * @ClassName:People
 * @Description:学员类
 * @Author qiao
 * @Date 2018/7/24 20:31
 **/

import java.util.Date;

public class People {
    private long id;
    private String name;
    private String info;
    private long creatTime;
    private long updateTime;
    private int job;
    private String password;
    private String picture;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(long creatTime) {
        this.creatTime = creatTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                ", job=" + job +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
