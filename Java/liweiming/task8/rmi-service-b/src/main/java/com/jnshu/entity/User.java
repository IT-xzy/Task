package com.jnshu.entity;

import java.io.Serializable;

/**
 * @program: task7
 * @description: 用户实体类
 * @author: Mr.Lee
 * @create: 2018-07-31 09:53
 **/
public class User implements Serializable {

    private static final long serialVersionUID = 1083868787360140556L;
    private Integer id;
    private Long create_at;
    private Long update_at;
    private String qq;
    private String head_pic;
    private long phone;
    private String email;
    private Integer emailState;
    private String name;
    private String learning_type;
    private Long entrance_time;
    private String school;
    private Integer online_id;
    private String daily_link;
    private String wish;
    private String tutor;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", qq='" + qq + '\'' +
                ", head_pic='" + head_pic + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", learning_type='" + learning_type + '\'' +
                ", entrance_time=" + entrance_time +
                ", school='" + school + '\'' +
                ", online_id=" + online_id +
                ", daily_link='" + daily_link + '\'' +
                ", wish='" + wish + '\'' +
                ", tutor='" + tutor + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emailState='" + emailState + '\'' +
                '}';
    }

    public Integer getEmailState() {
        return emailState;
    }

    public void setEmailState(Integer emailState) {
        this.emailState = emailState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getHead_pic() {
        return head_pic;
    }

    public void setHead_pic(String head_pic) {
        this.head_pic = head_pic;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getEntrance_time() {
        return entrance_time;
    }

    public void setEntrance_time(Long entrance_time) {
        this.entrance_time = entrance_time;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getOnline_id() {
        return online_id;
    }

    public void setOnline_id(Integer online_id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
