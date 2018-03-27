package com.myitschool.student;

import java.io.Serializable;

public class Student implements Serializable {
    private long id;
    private String name;
    private long qq;
    private String type;
    private String stime;
    private String graschool;
    private String classnum;
    private String link;
    private String mentor;
    private String conbrother;
    private String hknow;
    private long createAt;
    private long updateAt;

    public Student() {
        //  this.createAt = System.currentTimeMillis();
        //  this.updateAt = System.currentTimeMillis();
    }

    public void setId(int id){
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public long getQq() {
        return this.qq;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setStime(String stime){
        this.stime = stime;
    }

    public String getStime() {
        return this.stime;
    }

    public void setGraschool(String graschool) {
        this.graschool = graschool;
    }

    public String getGraschool() {
        return this.graschool;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum;
    }

    public String getClassnum() {
        return this.classnum;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public String getMentor() {
        return this.mentor;
    }

    public void setConbrother(String conbrother) {
        this.conbrother = conbrother;
    }

    public String getConbrother() {
        return this.conbrother;
    }

    public void setHknow(String hknow) {
        this.hknow = hknow;
    }

    public String getHknow() {
        return this.hknow;
    }

    public long getCreateAt() {
        return this.createAt;
    }

    public long getUpdateAt() {
        return this.updateAt;
    }

    public String toString() {
        return (getId() + " " + getName() + " " + getQq() + " " + getType() + " " + getStime()+ " " +
                getGraschool() + " " + getClassnum() + " " + getLink() + " " + getMentor() + " " + getConbrother()+ " " +
                getHknow() + " " + getCreateAt() + " " + getUpdateAt());
    }
}
