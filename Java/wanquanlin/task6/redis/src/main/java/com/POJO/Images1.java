package com.POJO;

import java.io.Serializable;

/**
 * @Author: Jaime
 * @Date: 2018/4/3 21:08
 * @Description: *
 */
public class Images1 implements Serializable{
    private static final long serialVersionUID = -1267719235225203410L;
    private int ID;
    private String picture;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Images1{" +
                "ID=" + ID +
                ", picture='" + picture + '\'' +
                '}';
    }
}
