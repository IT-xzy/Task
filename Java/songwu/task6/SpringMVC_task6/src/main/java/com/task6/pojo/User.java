package com.task6.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -8327745757141663568L;
    private int id;
    private String picture;
    private String position;
    private String name;
    private String introduction;

    public User() {
    }

    public User(String picture, String position, String name, String introduction) {
        this.picture = picture;
        this.position = position;
        this.name = name;
        this.introduction = introduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", position='" + position + '\'' +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +'\n'+
                '}';
    }
}
