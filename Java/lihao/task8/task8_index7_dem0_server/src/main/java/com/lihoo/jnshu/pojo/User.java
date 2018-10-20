package com.lihoo.jnshu.pojo;

import java.io.Serializable;

/**
 * #Title: User
 * #ProjectName task8_index7
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/12-13:53
 */


public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
