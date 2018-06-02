package com.fangyuyang.model;

import java.io.Serializable;

public class Student implements Serializable {
//    private static final long serialVersionUID = -4872209286912354817L;
    private int id;
    private int qq;
    private String name;
    private String course;
    private String school;
    private String old_brother;
    private String target;
    private String url;
    private int number;
    private long update_at;
    private long create_at;
    private String from_where;

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public String getFrom_where() {
        return from_where;
    }

    public void setFrom_where(String from_where) {
        this.from_where = from_where;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getOld_brother() {
        return old_brother;
    }

    public void setOld_brother(String old_brother) {
        this.old_brother = old_brother;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", qq=" + qq +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", school='" + school + '\'' +
                ", old_brother='" + old_brother + '\'' +
                ", target='" + target + '\'' +
                ", url='" + url + '\'' +
                ", number=" + number +
                ", update_at=" + update_at +
                ", create_at=" + create_at +
                ", from_where='" + from_where + '\'' +
                '}';
    }
}
