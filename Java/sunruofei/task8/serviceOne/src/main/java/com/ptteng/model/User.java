package com.ptteng.model;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/15  15:28
 * @Version 1.0
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 6377800853427408223L;
    private String name;
    private String password;
    private long id;
    private String phone;
    private String code;
    private String mail;


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", phone=" + phone +
                ", code='" + code + '\'' +
                '}';
    }
}

