package com.task5.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1563056272025335248L;
    int id;
    String userName;
    String password;
    String salt;
    long createAt;
    long updateAt;
    String headURL;
    String phoneNumber;
    String email;

    public User() {
    }

    public User(int id, String userName, String password, String salt,
                long createAt, long updateAt, String headURL, String phoneNumber, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.headURL = headURL;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", headURL='" + headURL + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public String getHeadURL() {
        return headURL;
    }

    public void setHeadURL(String headURL) {
        this.headURL = headURL;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
