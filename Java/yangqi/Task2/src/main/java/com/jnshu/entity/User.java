package com.jnshu.entity;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
    //表示ID
    private int id;
    private String name;
    private String QQ;
    private String major;
    private Long startTime;
    private String school;
    private int student_Id;
    private String daily_cone;
    private String desire;
    private String bre;
    private String know_from;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getStudent_Id() {
        return student_Id;
    }

    public void setStudent_Id(int student_Id) {
        this.student_Id = student_Id;
    }

    public String getDaily_cone() {
        return daily_cone;
    }

    public void setDaily_cone(String daily_cone) {
        this.daily_cone = daily_cone;
    }

    public String getDesire() {
        return desire;
    }

    public void setDesire(String desire) {
        this.desire = desire;
    }

    public String getBre() {
        return bre;
    }

    public void setBre(String bre) {
        this.bre = bre;
    }

    public String getKnow_from() {
        return know_from;
    }

    public void setKnow_from(String know_from) {
        this.know_from = know_from;
    }


    @Override
    public String toString() {
        return "UserDao.xml{id=" + id + ",name=" + name + ",QQ=" + QQ + ",major=" + major + ",starTime=" + startTime + ",school=" + school + ",student_Id=" + student_Id + ",daily_cone=" + daily_cone + "," +
                "desire=" + desire + ",bre=" + bre + ",know_from=" + know_from + "}";

    }
}
