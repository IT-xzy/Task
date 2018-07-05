package com.ptteng.model;

import java.io.Serializable;

/**
 * 查询数据库，获得报名后的学员姓名和所报的课程
 * 新建一个实体类，保存mybatis多表查询结果
 */
public class SignedUser implements Serializable {
    private String username;
    private String name;
    private String course;
    private String image;
    private Long createdAt;
    private String phone;
    private String email;

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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public SignedUser(String username,String name, String course, String image, Long createdAt, String phone, String email) {
        this.username = username;
        this.name = name;
        this.course = course;
        this.image = image;
        this.createdAt = createdAt;
        this.phone = phone;
        this.email = email;
    }

    public SignedUser() {
    }

    @Override
    public String toString() {
        return "SignedUser{" +
                "username='" + username + '\'' +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", image='" + image + '\'' +
                ", createdAt=" + createdAt +
                ", phone=" + phone +
                ", email=" + email +
                '}';
    }
}
