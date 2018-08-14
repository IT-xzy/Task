package com.jnshu.model;

public class User {
    private Integer id;

    private String userName;

    private String password;

    private Long loginTime;

    private String creatName;

    private Long creatTime;

    private String updateName;

    private Long updateTime;

    public User(Integer id, String userName, String password, Long loginTime, String creatName, Long creatTime, String updateName, Long updateTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.loginTime = loginTime;
        this.creatName = creatName;
        this.creatTime = creatTime;
        this.updateName = updateName;
        this.updateTime = updateTime;
    }

    public User() {
        super();
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

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}