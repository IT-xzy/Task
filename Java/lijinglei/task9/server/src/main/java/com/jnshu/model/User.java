package com.jnshu.model;

public class User implements java.io.Serializable{

    private static final long serialVersionUID = 4077329331699640331L;


    private Integer id;

    private String userName;

    private String password;

    private String telNum;

    private String email;

    private String userImage;

    private String salt;

    private Long loginTime;

    private String creatName;

    private Long creatTime;

    private String updateName;

    private Long updateTime;

    public User(Integer id, String userName, String password,  String telNum, String email, String userImage, String salt,Long loginTime, String creatName, Long creatTime, String updateName, Long updateTime) {
        this.id = id;
        this.userName = userName;
        this.telNum = telNum;
        this.email = email;
        this.userImage = userImage;
        this.password = password;
        this.salt = salt;
        this.loginTime = loginTime;
        this.creatName = creatName;
        this.creatTime = creatTime;
        this.updateName = updateName;
        this.updateTime = updateTime;
    }

    public User() {
        super();
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public String getCreatName() {
        return creatName;
    }

    public void setCreatName(String creatName) {
        this.creatName = creatName == null ? null : creatName.trim();
    }

    public Long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Long creatTime) {
        this.creatTime = creatTime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}