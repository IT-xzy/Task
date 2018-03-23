package com.ptteng.model;

public class Student {
    private long id;
    private String name;
    private String qq;
    private String goal;
    private String registration_date;
    private String graduated_from;
    private String number;
    private String daily_link;
    private String pledge;
    private String senior;
    private String konw_from;
    private Long created_at;
    private Long updated_at;

    public Student(){};

    public Student(String name, String qq, String goal, String registration_date, String graduated_from, String number, String daily_link, String pledge, String senior,String konw_from) {
        this.name = name;
        this.qq = qq;
        this.goal = goal;
        this.registration_date = registration_date;
        this.graduated_from = graduated_from;
        this.number = number;
        this.daily_link = daily_link;
        this.pledge = pledge;
        this.senior = senior;
        this.konw_from = konw_from;
    }

    @Override
    public String toString() {
        return "---->Student id=" + id +'\n' +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", goal='" + goal + '\'' +'\n' +
                ", registration_date='" + registration_date + '\'' +
                ", graduated_from='" + graduated_from + '\'' +
                ", number='" + number + '\n' +
                ", daily_link='" + daily_link + '\n' +
                ", pledge='" + pledge + '\'' +
                ", senior='" + senior + '\n' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ",kown_from="+ konw_from +
                '}' + '\n' + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%";
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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public String getGraduated_from() {
        return graduated_from;
    }

    public void setGraduated_from(String graduated_from) {
        this.graduated_from = graduated_from;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDaily_link() {
        return daily_link;
    }

    public void setDaily_link(String daily_link) {
        this.daily_link = daily_link;
    }

    public String getPledge() {
        return pledge;
    }

    public void setPledge(String pledge) {
        this.pledge = pledge;
    }

    public String getSenior() {
        return senior;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }

    public Long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Long updated_at) {
        this.updated_at = updated_at;
    }

    public String getKonw_from() {
        return konw_from;
    }

    public void setKonw_from(String konw_from) {
        this.konw_from = konw_from;
    }
}