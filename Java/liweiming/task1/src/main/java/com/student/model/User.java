package com.student.model;

import com.student.tools.TimeTransition;

import java.util.TimerTask;

public class User {
    private int id;
    private long create_at;
    private long update_at;
    private String qq;
    private String name;
    private String learning_type;
    private long entrance_time;
    private String school;
    private int online_id;
    private String daily_link;
    private String wish;
    private String tutor;



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", qq='" + qq + '\'' +
                ", name='" + name + '\'' +
                ", learning_type='" + learning_type + '\'' +
                ", entrance_time=" + entrance_time +
                ", school='" + school + '\'' +
                ", online_id=" + online_id +
                ", daily_link='" + daily_link + '\'' +
                ", wish='" + wish + '\'' +
                ", tutor='" + tutor + '\'' +
                '}';
    }


    //    省略get、set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at() {
        this.create_at = TimeTransition.dateToLong(new java.util.Date());
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at() {
        this.update_at = TimeTransition.dateToLong(new java.util.Date());
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLearning_type() {
        return learning_type;
    }

    public void setLearning_type(String learning_type) {
        this.learning_type = learning_type;
    }

    public long getEntrance_time() {
        return entrance_time;
    }

    public void setEntrance_time(long entrance_time) {
        this.entrance_time = entrance_time;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getOnline_id() {
        return online_id;
    }

    public void setOnline_id(int online_id) {
        this.online_id = online_id;
    }

    public String getDaily_link() {
        return daily_link;
    }

    public void setDaily_link(String daily_link) {
        this.daily_link = daily_link;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }


}
