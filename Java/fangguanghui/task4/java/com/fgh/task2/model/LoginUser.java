package com.fgh.task2.model;

public class LoginUser {
    private long id;
    private String name;
    private String password;
    private String MD5Pass;
    private int SaveTime;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMD5Pass() {
        return MD5Pass;
    }

    public void setMD5Pass(String MD5Pass) {
        this.MD5Pass = MD5Pass;
    }

    public int getSaveTime() {
        return SaveTime;
    }

    public void setSaveTime(int saveTime) {
        SaveTime = saveTime;
    }
}
