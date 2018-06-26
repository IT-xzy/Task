package com.task1.pojo;

import java.text.SimpleDateFormat;

public class User {
    private String name;
    private String qq;
    private String type;
    private String admissionTime;
    private String school;
    private String onlineNum;
    private String dailyLink;
    private String declaration;
    private String elder;
    private String knewFrom;
    private long id;
    private long createAt;
    private long updateAt;

    public User() {

    }


    public User(String name, String qq, String type, String admissionTime, String school, String onlineNum,
                String dailyLink, String declaration, String elder, String knewFrom) {
        this.name = name;
        this.qq = qq;
        this.type = type;
        this.admissionTime = admissionTime;
        this.school=school;
        this.onlineNum = onlineNum;
        this.dailyLink = dailyLink;
        this.declaration = declaration;
        this.elder = elder;
        this.knewFrom = knewFrom;

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

    public String getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(String admissionTime) {
        this.admissionTime = admissionTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getOnlineNum() {
        return onlineNum;
    }

    public void setOnlineNum(String onlineNum) {
        this.onlineNum = onlineNum;
    }

    public String getDailyLink() {
        return dailyLink;
    }

    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getElder() {
        return elder;
    }

    public void setElder(String elder) {
        this.elder = elder;
    }

    public String getKnewFrom() {
        return knewFrom;
    }

    public void setKnewFrom(String knewFrom) {
        this.knewFrom = knewFrom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    public String toString() {

        String create= simpleDateFormat.format(createAt);
        String update= simpleDateFormat.format(updateAt);
        return "User{" +
                "name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", type='" + type + '\'' +
                ", admissionTime='" + admissionTime + '\'' +
                ", school='" + school + '\'' +
                ", onlineNum='" + onlineNum + '\'' +
                ", dailyLink='" + dailyLink + '\'' +
                ", declaration='" + declaration + '\'' +
                ", elder='" + elder + '\'' +
                ", knewFrom='" + knewFrom + '\'' +
                ", id=" + id +
                ", create='" + create + '\'' +
                ", update='" +  update + '\'' +"\n"+
                '}';
    }
}
