package com.model;


import java.io.Serializable;

//转存的pojo
public class StudentCustom implements Serializable {
    private static final long serialVersionUID = 123L;
    private String headurl;
    private int id;

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentCustom{" +
                "headurl='" + headurl + '\'' +
                ", id=" + id +
                '}';
    }
}
