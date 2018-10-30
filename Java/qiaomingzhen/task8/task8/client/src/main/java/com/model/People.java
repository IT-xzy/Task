package com.model;/*
 * @ClassName:People
 * @Description:学员类
 * @Author qiao
 * @Date 2018/7/24 20:31
 **/

import java.io.Serializable;

public class People implements Serializable {
    private static final long serialVersionUID = 1547877882755683151L;
    private long id;
    private String name;
    private String info;
    private int job;
    private String password;
    private String picture;
    private String type;
    private Long tel;
    private String email;
    private Integer status;
    private long loginTime;
    private long creatTime;
    private long updateTime;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
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

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", job=" + job +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                ", type='" + type + '\'' +
                ", tel=" + tel +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", loginTime=" + loginTime +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
