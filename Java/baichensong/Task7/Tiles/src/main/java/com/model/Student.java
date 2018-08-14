package com.model;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 123L;
    private int id;
    private int studentID;
    private String username;
    private String name;
    private String introduction;
    private String img;
    private int outstanding;
    private String zhiye;
    private Long phone;
    private String email;
    private Long startTime;
    private Long endTime;
     private Long create_at;
     private Long update_at;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(int outstanding) {
        this.outstanding = outstanding;
    }

    public String getZhiye() {
        return zhiye;
    }

    public void setZhiye(String zhiye) {
        this.zhiye = zhiye;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentID=" + studentID +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", img='" + img + '\'' +
                ", outstanding=" + outstanding +
                ", zhiye='" + zhiye + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }
}
