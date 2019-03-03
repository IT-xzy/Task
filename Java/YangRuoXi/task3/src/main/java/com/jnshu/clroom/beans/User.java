package com.jnshu.clroom.beans;

import org.springframework.stereotype.Component;

@Component
public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String userRole;
    private Long createTime = System.currentTimeMillis();
    private Integer createId;
    private String privileges;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userRole='" + userRole + '\'' +
                ", createTime=" + createTime +
                ", createId=" + createId +
                ", privileges='" + privileges + '\'' +
                '}';
    }

    public User() {
    }

    public User(Integer userId, String userName, String password, String userRole, Long createTime, Integer createId, String privileges) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
        this.createTime = createTime;
        this.createId = createId;
        this.privileges = privileges;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Long getCreateTime() {
        return createTime;
    }



    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }
}
