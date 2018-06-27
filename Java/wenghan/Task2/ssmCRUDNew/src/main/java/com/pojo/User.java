package com.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -8480028290230030521L;
    private String name;
    private int age;
    private String qq;
    private long enrolmentTime;
    private String school;
    private String desire;
    private int Tid;
    private String channel;
    private long id;
    private long create_at;
    private long update_at;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", qq='" + qq + '\'' +
                ", enrolmentTime=" + enrolmentTime +
                ", school='" + school + '\'' +
                ", desire='" + desire + '\'' +
                ", Tid=" + Tid +
                ", channel='" + channel + '\'' +
                ", id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}'+"\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public long getEnrolmentTime() {
        return enrolmentTime;
    }

    public void setEnrolmentTime(long enrolmentTime) {
        this.enrolmentTime = enrolmentTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDesire() {
        return desire;
    }

    public void setDesire(String desire) {
        this.desire = desire;
    }

    public int getTid() {
        return Tid;
    }

    public void setTid(int tid) {
        Tid = tid;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

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

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }
}
