package com.aaa.model;


import java.sql.Date;

public class User {
    private int id;
    private String name;
    private String password;
    private String birth;
//创建无参构造器，初始化数据
    public User() {

    }
//创建有参构造器

    public User(int id, String name, String password, String birth) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birth = birth;
    }

    //Getter和Setter方法封装变量属性


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}
