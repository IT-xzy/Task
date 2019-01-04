package com.xiaobo.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class User {
    private int id;
    private String name;
    private String sex;
    private String phone;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSex() {
        return sex;
    }
    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSex(String sex) { this.sex =sex;}
    public void setPhone(String phone) { this.phone =phone;}

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", sex=" + sex + ",phone=" + phone + "}";
    }
}
