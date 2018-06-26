package com.ev.entity;

public class User {

    //用户姓名
    private String name;
    //密钥
    private String keyValue;
    //邮箱
    private String email;
    //电话号码
    private String phoneNumber;
    //数据库id
    private Long id;
    //更新时间
    private Long updateAt;
    //创建时间
    private Long createAt;
    //密码盐
    private String salt;
    //用来传递密码的字段，数据库无该字段
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

    public String getSalt() { return salt; }

    public void setSalt(String salt) { this.salt = salt; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id=" + id +
                ", updateAt=" + updateAt +
                ", createAt=" + createAt +
                '}';
    }
}
