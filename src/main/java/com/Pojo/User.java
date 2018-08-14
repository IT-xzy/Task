package com.Pojo;

import java.io.Serializable;

public class User implements Serializable {
    private String userId;
    private String userPassword;
    private String userName;
    private String userTel;
    private String userMail;
    private String userPhoto;
    private String userSex;
    private int userQq;
    private String userType;
    private String userSchool;
    private String userDailyLink;
    private String userWords;
    private String userBrother;
    private Long create_at;
    private Long update_at;
    private String create_by;
    private String update_by;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public int getUserQq() {
        return userQq;
    }

    public void setUserQq(int userQq) {
        this.userQq = userQq;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public String getUserDailyLink() {
        return userDailyLink;
    }

    public void setUserDailyLink(String userDailyLink) {
        this.userDailyLink = userDailyLink;
    }

    public String getUserWords() {
        return userWords;
    }

    public void setUserWords(String userWords) {
        this.userWords = userWords;
    }

    public String getUserBrother() {
        return userBrother;
    }

    public void setUserBrother(String userBrother) {
        this.userBrother = userBrother;
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

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public User() {
    }

    public User(String userId, String userPassword, String userName, String userTel, String userMail, String userPhoto, String userSex, int userQq, String userType, String userSchool, String userDailyLink, String userWords, String userBrother, Long create_at, Long update_at, String create_by, String update_by) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userTel = userTel;
        this.userMail = userMail;
        this.userPhoto = userPhoto;
        this.userSex = userSex;
        this.userQq = userQq;
        this.userType = userType;
        this.userSchool = userSchool;
        this.userDailyLink = userDailyLink;
        this.userWords = userWords;
        this.userBrother = userBrother;
        this.create_at = create_at;
        this.update_at = update_at;
        this.create_by = create_by;
        this.update_by = update_by;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", userSex=" + userSex +
                ", userQq=" + userQq +
                ", userType='" + userType + '\'' +
                ", userSchool='" + userSchool + '\'' +
                ", userDailyLink='" + userDailyLink + '\'' +
                ", userWords='" + userWords + '\'' +
                ", userBrother='" + userBrother + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", create_by='" + create_by + '\'' +
                ", update_by='" + update_by + '\'' +
                '}';
    }
}