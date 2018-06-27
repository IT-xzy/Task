package com.task.entity;

public class UserToken {

    private String name;
    private String pswd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "name='" + name + '\'' +
                ", pswd='" + pswd + '\'' +
                '}';
    }
}
