package com.ptteng.entity;

/**
 * @ClassName User
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/15  15:28
 * @Version 1.0
 **/
public class User {
    private String name;
    private String password;
    private long id;

    public User(String name, String password) {
    }
    public User(){

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
                '}';
    }
}

