package com.POJO;

import java.io.Serializable;

/**
 * @Author: Jaime
 * @Date: 2018/4/3 23:20
 * @Description: *
 */
public class GameModel implements Serializable{
    private int ID;
    private String model;
    private String description;
    private String picture;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
