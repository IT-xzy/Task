package com.ev.entity;

public class User {

    private String name;
    private String keyValue;
    private String email;
    private String phoneNumber;
    private Long id;
    private Long updateAt;
    private Long createAt;
    private String salt;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String name, String keyValue, String email, String phoneNumber, Long updateAt, Long createAt, String salt) {
        this.name = name;
        this.keyValue = keyValue;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.updateAt = updateAt;
        this.createAt = createAt;
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", keyValue='" + keyValue + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id=" + id +
                ", updateAt=" + updateAt +
                ", createAt=" + createAt +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
