package com.ptteng.model;

import java.io.Serializable;

public class User implements Serializable {
    private long id;
    private String username;
    private String password;
    private String name;
    private String image;
    private int courseId;
    private String email;
    private String address;
    private String phone;

    private long createdAt;
    private long updatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    //构造方法
    public User() {
    }
    //注册用
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //报名用

    public User(String name, String image, String email, String address, String phone, int courseId) {
        this.name = name;
        this.courseId = courseId;
        this.image = image;
        this.email = email;
        this.address = address;
        this.phone = phone;

    }

    public User(String username, String password, String name, String image, String email, String address, String phone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.image = image;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", courseId=" + courseId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}' + '\n';
    }
}
