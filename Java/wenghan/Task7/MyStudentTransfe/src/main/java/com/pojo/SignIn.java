package com.pojo;

public class SignIn {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "SignIn{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
