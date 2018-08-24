package com.jns.pojo;

public class Course {
    private  int id;
    private String course;
    private  String couIntr;
    private  String grow;
    private  int compNum;
    private  String salary1;
    private  String salary2;
    private  String salary3;
    private  String tips;

    @Override
    public String toString() {
        return "课程["+course+"]";
    }

    public int getId() {
        return id;
    }

    public Course setId(int id) {
        this.id = id;
        return this;
    }

    public String getCourse() {
        return course;
    }

    public Course setCourse(String course) {
        this.course = course;
        return this;
    }

    public String getCouIntr() {
        return couIntr;
    }

    public Course setCouIntr(String couIntr) {
        this.couIntr = couIntr;
        return this;
    }

    public String getGrow() {
        return grow;
    }

    public Course setGrow(String grow) {
        this.grow = grow;
        return this;
    }

    public int getCompNum() {
        return compNum;
    }

    public Course setCompNum(int compNum) {
        this.compNum = compNum;
        return this;
    }

    public String getSalary1() {
        return salary1;
    }

    public Course setSalary1(String salary1) {
        this.salary1 = salary1;
        return this;
    }

    public String getSalary2() {
        return salary2;
    }

    public Course setSalary2(String salary2) {
        this.salary2 = salary2;
        return this;
    }

    public String getSalary3() {
        return salary3;
    }

    public Course setSalary3(String salary3) {
        this.salary3 = salary3;
        return this;
    }

    public String getTips() {
        return tips;
    }

    public Course setTips(String tips) {
        this.tips = tips;
        return this;
    }
}
