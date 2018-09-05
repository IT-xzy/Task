package com.task5.pojo;

public class Student {
    private long id;
    private long create_at;
    private String name;
    private String qq;
    private String professional;
    private String start_time;
    private String university;
    private Integer online_id;
    private String daily_url;
    private String oath;
    private String counselor;
    private String city;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
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

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Integer getOnline_id() {
        return online_id;
    }

    public void setOnline_id(Integer online_id) {
        this.online_id = online_id;
    }

    public String getDaily_url() {
        return daily_url;
    }

    public void setDaily_url(String daily_url) {
        this.daily_url = daily_url;
    }

    public String getOath() {
        return oath;
    }

    public void setOath(String oath) {
        this.oath = oath;
    }

    public String getCounselor() {
        return counselor;
    }

    public void setCounselor(String counselor) {
        this.counselor = counselor;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", create_at='" + create_at + '\'' +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", professional='" + professional + '\'' +
                ", start_time='" + start_time + '\'' +
                ", university='" + university + '\'' +
                ", online_id=" + online_id +
                ", daily_url='" + daily_url + '\'' +
                ", oath='" + oath + '\'' +
                ", counselor='" + counselor + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
