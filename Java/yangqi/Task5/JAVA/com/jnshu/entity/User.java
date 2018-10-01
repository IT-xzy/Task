package com.jnshu.entity;

public class User {

    private long id;
    private String name;
    private String password;
    private String  salt;
    private String despwd;
    private long landtime;

    @Override
    public String toString() {
        return "Userdao{" +
                ",id=" + id +
                ",name='" + name + '\'' +
                ",password='" + password + '\'' +
                ",salt='" + salt + '\'' +
                ",despwd='" + despwd + '\'' +
                ",landtime='" + landtime +
                "}";
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }
    public String getDespwd() {
        return despwd;
    }

    public void setDespwd(String despwd) {
        this.despwd = despwd;
    }

    public long getLandtime() {
        return landtime;
    }

    public void setLandtime(long landtime) {
        this.landtime = landtime;
    }
}
