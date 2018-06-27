package com.longhang.model;

import java.io.Serializable;

public class Student implements Serializable {
    private Long id;
    private String name;
    private String qq;
    private String wish;
    private Long create_at;
    private Long update_at;
    private String major;//修真类型
    private String  picture;//图片
    private boolean goodwork;//工作
    private boolean graduation;//结业
    private boolean goodstu;//好学生



    public Student() {}
    public Student(Long id, String name, String qq, String wish, String major, Long create_at, Long update_at, String picture,boolean goodwork,boolean graduation,boolean goodstu) {
        this.id = id;
        this.name = name;
        this.qq = qq;
        this.wish = wish;
        this.major = major;
        this.create_at = create_at;
        this.update_at = update_at;
        this.picture = picture;
        this.goodwork=goodwork;
        this.graduation=graduation;
        this.goodstu=goodstu;
        }

    public boolean isGoodstu() {
        return goodstu;
    }

    public void setGoodstu(boolean goodstu) {
        this.goodstu = goodstu;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }
    public boolean isGraduation() {
        return graduation;
    }
    public void setGraduation(boolean graduation) {
        this.graduation = graduation;
    }
    public boolean isGoodwork() {
        return goodwork;
    }
    public void setGoodwork(boolean goodwork) {
        this.goodwork = goodwork;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", wish='" + wish + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", major='" + major + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}