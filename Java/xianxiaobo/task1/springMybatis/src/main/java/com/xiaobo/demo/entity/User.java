package com.xiaobo.demo.entity;

import org.springframework.stereotype.Repository;


public class User {
    private int id;
    private String name;
    private String hope;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getHope() {
        return hope;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHope(String hope) { this.hope =hope;}

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", hope=" + hope + "]";
    }
}
