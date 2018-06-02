package com.ssm.model;

import java.io.Serializable;

public class UserRegister implements Serializable {
    private static final long serialVersionUID = 6008009061332700237L;
    private Long id;
    private String username;
    private String password;
    private Long phoneNum;
    private Long create_at;
    private Long update_at;

    @Override
    public String toString() {
        return "UserRegister{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum=" + phoneNum +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }
}
