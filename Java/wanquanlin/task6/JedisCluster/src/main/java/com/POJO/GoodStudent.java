package com.POJO;

import java.io.Serializable;

/**
 * @Author: Jaime
 * @Date: 2018/4/3 0:46
 * @Description: *
 */
public class GoodStudent implements Serializable{
    private  Long ID;
    private String name;
    private  String job;
    private  String picture;

    public GoodStudent() {

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "GoodStudent{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
