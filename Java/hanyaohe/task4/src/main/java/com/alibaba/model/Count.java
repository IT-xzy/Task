package com.alibaba.model;

public class Count {
    private Integer id;

    private String online;
    private String workers;
    private String user;
    private String pass;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getOnline() {

        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getWorkers() {

        return workers;
    }

    public void setWorkers(String workers) {

        this.workers = workers;
    }

    public String getUser() {

        return user;
    }

    public void setUser(String user) {

        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Count{" +
                "id=" + id +
                ", online='" + online + '\'' +
                ", workers='" + workers + '\'' +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
