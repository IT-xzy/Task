package com.jnshu.taskone.model;

import com.jnshu.taskone.tools.TimeTransition;

public class User {
    private int id;
    //姓名
    private String username;
    //qq
    private String qq;
    //修真类型
    private String profession;
    //预计入学时间
    private Long join_date;
    //毕业院校
    private String school;
    //线上id
    private String online_id;
    //日报连接
    private String daily_url;
    //立愿
    private String declaration;
    //辅导师兄
    private String counselor;
    //创建时间
    private Long create_time;
    //更新时间
    private Long update_time;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", 姓名='" + username + '\'' +
                ", qq='" + qq + '\'' +
                ", 修真类型='" + profession + '\'' +
                ", 预计入学时间=" + TimeTransition.longToString(join_date) +
                ", 毕业院校='" + school + '\'' +
                ", 线上id='" + online_id + '\'' +
                ", 日报连接='" + daily_url + '\'' +
                ", 立愿='" + declaration + '\'' +
                ", 辅导师兄='" + counselor + '\'' +
                ", 创建时间=" + TimeTransition.longToString(create_time) +
                ", 上次更新时间=" + TimeTransition.longToString(update_time) +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Long getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Long join_date) {
        this.join_date = join_date;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getOnline_id() {
        return online_id;
    }

    public void setOnline_id(String online_id) {
        this.online_id = online_id;
    }

    public String getDaily_url() {
        return daily_url;
    }

    public void setDaily_url(String daily_url) {
        this.daily_url = daily_url;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getCounselor() {
        return counselor;
    }

    public void setCounselor(String counselor) {
        this.counselor = counselor;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time() {
        this.create_time = TimeTransition.dateTolong(new java.util.Date());
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time() {
        this.update_time = TimeTransition.dateTolong(new java.util.Date());
    }
}
