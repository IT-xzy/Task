package com.jns.entity;

public class Users {
    private long id;
    private int phone;
    private String password;
    private long create_at;
    private String name;
    private String sign;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
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
        return "user[账号:"+phone+",登录时间:"+ create_at +"]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
