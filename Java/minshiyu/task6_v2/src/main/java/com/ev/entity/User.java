package com.ev.entity;

public class User {

    //用户名
    private String name;
    //键
    private String keyValue;
    //邮箱
    private String email;
    //电话号码
    private String phoneNumber;
    //数据库id
    private Long id;
    //创建时间
    private Long updateAt;
    //更新时间
    private Long createAt;
    //密码的盐
    private String salt;
    //传递密码用，数据库无此字段
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
