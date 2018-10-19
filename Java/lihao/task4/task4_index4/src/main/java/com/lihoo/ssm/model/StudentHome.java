package com.lihoo.ssm.model;

public class StudentHome {
    private Long id;

    private String username;

    private String userInfo;

    private Integer workStatus;

    private String headImg;

    private Integer greatUser;

    public StudentHome() {
    }

    public StudentHome(Long id, String username, String userInfo, Integer workStatus, String headImg, Integer greatUser) {
        this.id = id;
        this.username = username;
        this.userInfo = userInfo;
        this.workStatus = workStatus;
        this.headImg = headImg;
        this.greatUser = greatUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(Integer workStatus) {
        this.workStatus = workStatus;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getGreatUser() {
        return greatUser;
    }

    public void setGreatUser(Integer greatUser) {
        this.greatUser = greatUser;
    }

    @Override
    public String toString() {
        return "StudentHome{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", workStatus=" + workStatus +
                ", headImg='" + headImg + '\'' +
                ", greatUser=" + greatUser +
                '}';
    }
}