package com.jnshu.model;

import java.sql.Date;

public class User {
    private Integer id;
    private String name;
    private String qq;
    private String type;
    private Date entranceTime;
    private String school;
    private Integer onlineNum;
    private String dailyLink;
    private String wish;
    private String brother;
    private String whereKnown;
    private Date create_at;
    private Date update_at;

    //    public User(){
//    }
    /*public User(long id, String name, String qq, String type, long entranceTime, String school, String onlineNum, String dailyLink, String wish, String brother, String whereKnown, long create_at, long update_at){
        this.id=id;
        this.name=name;
        this.qq=qq;
        this.type=type;
        this.entranceTime=entranceTime;
        this.school=school;
        this.onlineNum=onlineNum;
        this.dailyLink=dailyLink;
        this.wish=wish;
        this.brother=brother;
        this.whereKnown=whereKnown;
        this.create_at=create_at;
        this.update_at=update_at;

    }
    public User(String name, String qq, String type, long entranceTime, String school, String onlineNum, String dailyLink, String wish, String brother, String whereKnown, long create_at, long update_at){
        this.name=name;
        this.qq=qq;
        this.type=type;
        this.entranceTime=entranceTime;
        this.school=school;
        this.onlineNum=onlineNum;
        this.dailyLink=dailyLink;
        this.wish=wish;
        this.brother=brother;
        this.whereKnown=whereKnown;
        this.create_at=create_at;
        this.update_at=update_at;

    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getOnlineNum() {
        return onlineNum;
    }

    public void setOnlineNum(Integer onlineNum) {
        this.onlineNum = onlineNum;
    }

    public String getDailyLink() {
        return dailyLink;
    }

    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getWhereKnown() {
        return whereKnown;
    }

    public void setWhereKnown(String whereKnown) {
        this.whereKnown = whereKnown;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", type='" + type + '\'' +
                ", entranceTime=" + entranceTime +
                ", school='" + school + '\'' +
                ", onlineNum=" + onlineNum +
                ", dailyLink='" + dailyLink + '\'' +
                ", wish='" + wish + '\'' +
                ", brother='" + brother + '\'' +
                ", whereKnown='" + whereKnown + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }
}
