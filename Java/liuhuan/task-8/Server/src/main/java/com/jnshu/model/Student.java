package com.jnshu.model;

import java.io.Serializable;

/**
 * @program: smsdemo
 * @description: 学生实体类
 * @author: Mr.xweiba
 * @create: 2018-05-29 22:50
 **/

public class Student implements Serializable {
    // 序列化后缓存
    private static final long serialVersionUID = 7935867480473067255L;

    private Integer id;
    private String stuName;
    private String stuQq;
    private String stuMail;
    private Integer stuMailState;
    private String stuTelephone;
    private Integer stuProfession;
    private Long join_date;
    private String stuSchool;
    private Integer online_id;
    private String daily_url;
    private String declaration;
    private Integer isSuper;
    private String counselor;
    private Integer isWork;
    private String headurl;
    private String stuTitle;
    private Long create_time;
    private Long update_time;
    private String create_by;
    private String update_by;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", stuQq='" + stuQq + '\'' +
                ", stuMail='" + stuMail + '\'' +
                ", stuMailState='" + stuMailState + '\'' +
                ", stuTelephone=" + stuTelephone +
                ", stuProfession=" + stuProfession +
                ", join_date=" + join_date +
                ", stuSchool='" + stuSchool + '\'' +
                ", online_id=" + online_id +
                ", daily_url='" + daily_url + '\'' +
                ", declaration='" + declaration + '\'' +
                ", isSuper=" + isSuper +
                ", counselor='" + counselor + '\'' +
                ", isWork=" + isWork +
                ", headurl='" + headurl + '\'' +
                ", stuTitle='" + stuTitle + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", create_by='" + create_by + '\'' +
                ", update_by='" + update_by + '\'' +
                '}';
    }

    public Integer getStuMailState() {
        return stuMailState;
    }

    public void setStuMailState(Integer stuMailState) {
        this.stuMailState = stuMailState;
    }

    public String getStuMail() {
        return stuMail;
    }

    public void setStuMail(String stuMail) {
        this.stuMail = stuMail;
    }

    public String getStuTelephone() {
        return stuTelephone;
    }

    public void setStuTelephone(String stuTelephone) {
        this.stuTelephone = stuTelephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuQq() {
        return stuQq;
    }

    public void setStuQq(String stuQq) {
        this.stuQq = stuQq;
    }

    public Integer getStuProfession() {
        return stuProfession;
    }

    public void setStuProfession(Integer stuProfession) {
        this.stuProfession = stuProfession;
    }

    public Long getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Long join_date) {
        this.join_date = join_date;
    }

    public String getStuSchool() {
        return stuSchool;
    }

    public void setStuSchool(String stuSchool) {
        this.stuSchool = stuSchool;
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

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public Integer getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(Integer isSuper) {
        this.isSuper = isSuper;
    }

    public String getCounselor() {
        return counselor;
    }

    public void setCounselor(String counselor) {
        this.counselor = counselor;
    }

    public Integer getIsWork() {
        return isWork;
    }

    public void setIsWork(Integer isWork) {
        this.isWork = isWork;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public String getStuTitle() {
        return stuTitle;
    }

    public void setStuTitle(String stuTitle) {
        this.stuTitle = stuTitle;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }
}
