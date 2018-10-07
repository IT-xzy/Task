package com.leo.model;

import java.io.Serializable;

public class Student4 implements Serializable{
    
    private static final long serialVersionUID = -242410410003878154L;
    private Long id;

    private String name;

    private String introduction;

    private String picture;

    private String job;

    private Boolean isWork;

    private Boolean isExcellent;

    private Long createAt;

    private Long updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Boolean getIsWork() {
        return isWork;
    }

    public void setIsWork(Boolean isWork) {
        this.isWork = isWork;
    }

    public Boolean getIsExcellent() {
        return isExcellent;
    }

    public void setIsExcellent(Boolean isExcellent) {
        this.isExcellent = isExcellent;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
    
    @Override
    public String toString(){
        return name;
    }
}