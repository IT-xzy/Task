package com.restful.model;

import java.io.Serializable;
/*
* POJO
*
* Student实体类
*
* */

public class Student  implements Serializable {


    private int id;
    private long create_at;
    private long update_at;
    private String name;
    private long qq;
    private int type;
    private String startTime;
    private String school;
    private int stuNum;
    private String dailyLink;
    private String pro;
    private String brother;
    private int userId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQq() {
        return qq;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getDailyLink() {
        return dailyLink;
    }

    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "\n" + "Student{" +
                "id=" + id + "\n" +
                ", create_at=" + create_at + "\n" +
                ", update_at=" + update_at + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", qq=" + qq + "\n" +
                ", type=" + type + "\n" +
                ", startTime='" + startTime + '\'' + "\n" +
                ", school='" + school + '\'' + "\n" +
                ", stuNum=" + stuNum + "\n" +
                ", dailyLink='" + dailyLink + '\'' + "\n" +
                ", pro='" + pro + '\'' + "\n" +
                ", brother='" + brother + '\'' + "\n" +
                ", userId=" + userId + "\n" +
                '}' + "\n";
    }
}
