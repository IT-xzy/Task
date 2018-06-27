package com.ev.entity;

public class User {

    //用户名
    private String name;
    //存储db的验证密钥
    private String keyValue;
    //邮箱地址
    private String email;
    //电话号码
    private String phoneNumber;
    //db中的id
    private Long id;
    //用户信息时间
    private Long updateAt;
    //用户创建时间
    private Long createAt;
    //密码加的盐
    private String salt;
    //页面传值时用来存储明文密码的字段
    private String password;
    //注册时重复输入的密码
    private String rePassword;
    //短信验证码
    private String authCode;
    //邮箱验证状态
    private int status;

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User() {
    }

    public User(String name, String keyValue, String email, String phoneNumber, Long id, Long updateAt, Long createAt, String salt, String password, String rePassword, String authCode, int status) {
        this.name = name;
        this.keyValue = keyValue;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.updateAt = updateAt;
        this.createAt = createAt;
        this.salt = salt;
        this.password = password;
        this.rePassword = rePassword;
        this.authCode = authCode;
        this.status = status;
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
                ", rePassword='" + rePassword + '\'' +
                ", authCode='" + authCode + '\'' +
                ", status=" + status +
                '}';
    }
}
