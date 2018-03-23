package com.ycc.model;

public class User {
    private  int id;
    private String stu_name;
    private int number;
    private int qq;
    private String type;
    private String university;
    private long time;
    private String link;
    private String pledge;
    private String senior;
    private String locality;
    private long create_at;
    private long update_at;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", stu_name='" + stu_name + '\'' +
                ", number=" + number +
                ", qq=" + qq +
                ", type='" + type + '\'' +
                ", university='" + university + '\'' +
                ", time=" + time +
                ", link='" + link + '\'' +
                ", pledge='" + pledge + '\'' +
                ", senior='" + senior + '\'' +
                ", locality='" + locality + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }
}
