package com.fgh.task2.model;

import org.springframework.stereotype.Component;

@Component
public class LoginUser {
    private int id;
    private String phcount;
    private String password;
    private String MD5Pass;
    private int SaveTime;
    private String mail;
    private String photo;
    private String mailcode;
    private int mailstatus;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return phcount;
    }

    public void setName(String name) {
        this.phcount = name;
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

    public String getEmail() {
        return mail;
    }

    public void setEmail(String email) {
        this.mail = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMailcode() {
        return mailcode;
    }

    public void setMailcode(String mailcode) {
        this.mailcode = mailcode;
    }

    public int getMailstatus() {
        return mailstatus;
    }

    public void setMailstatus(int mailstatus) {
        this.mailstatus = mailstatus;
    }
}
