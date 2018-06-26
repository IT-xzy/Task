package com.opt.model;

import java.io.Serializable;
/*
* POJO
*
* Student实体类
*
* */

public class Student implements Serializable {


    private int id;
    private String stuName;
    private String stuPhoto;
    private int sex;
    private int age;
    private String school;
    private String office;
    private int pro_id;
    private String recommend;
    private long create_at;
    private long update_at;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", stuPhoto='" + stuPhoto + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", school='" + school + '\'' +
                ", office='" + office + '\'' +
                ", pro_id=" + pro_id +
                ", recommend='" + recommend + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPhoto() {
        return stuPhoto;
    }

    public void setStuPhoto(String stuPhoto) {
        this.stuPhoto = stuPhoto;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
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
}
