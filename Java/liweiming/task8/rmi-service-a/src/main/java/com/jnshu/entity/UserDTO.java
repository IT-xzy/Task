package com.jnshu.entity;

import java.io.Serializable;

/**
 * @program: Tiles
 * @description: 数据传输类
 * @author: Mr.Lee
 * @create: 2018-07-04 00:45
 **/
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1037903218000717983L;
    private Integer id;
    private String username;
    private String password;
    private String photo;
    private long phone;
    private String email;
    private int emailState;


    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", emailState=" + emailState +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmailState() {
        return emailState;
    }

    public void setEmailState(int emailState) {
        this.emailState = emailState;
    }
}
