package com.jns.pojo;

public class Users {
    private long id;
    private String phone;
    private String password;
    private long create_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }


    @Override
    public String toString() {
        return "user[账号:"+phone+",登录时间:"+create_at+"]";
    }
}
