package com.task.models;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = -7750107502624273207L;
    private int id;
    private long createdAt;
    private long updatedAt;
    private  String name;
    private  String profession;
    private int startTime;
    private int endTime;
    private int studentID;
    private  String isWorked;
    private String company;
    private  String position;
    private  String duty;

    //在学弟子登记
    public Student(long createdAt, String name, String profession, int startTime, int studentID, String isWorked) {
        this.createdAt = createdAt;
        this.name = name;
        this.profession = profession;
        this.startTime = startTime;
        this.studentID = studentID;
        this.isWorked = isWorked;
    }

    //毕业弟子登记
    public Student(long createdAt, String name, String profession, int startTime, int endTime, int studentID, String isWorked, String company, String position, String duty) {
        this.createdAt = createdAt;
        this.name = name;
        this.profession = profession;
        this.startTime = startTime;
        this.endTime = endTime;
        this.studentID = studentID;
        this.isWorked = isWorked;
        this.company = company;
        this.position = position;
        this.duty = duty;
    }
   //在学弟子修改


    public Student(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getIsWorked() {
        return isWorked;
    }

    public void setIsWorked(String isWorked) {
        this.isWorked = isWorked;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", studentID=" + studentID +
                ", isWorked='" + isWorked + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", duty='" + duty + '\'' +
                '}';
    }
}
