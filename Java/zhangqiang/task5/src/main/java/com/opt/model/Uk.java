package com.opt.model;

public class Uk {
    private int id;
    private int uid;
    private String Key;

    @Override
    public String toString() {
        return "Uk{" +
                "id=" + id +
                ", uid=" + uid +
                ", Key='" + Key + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }
}
