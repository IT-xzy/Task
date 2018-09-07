package com.jnshu.model;

import java.util.Date;

public class User implements java.io.Serializable{

    private static final long serialVersionUID = -777748818037145234L;

    private Integer id;

    private Date createAt;

    private Date updateAt;

    private String name;

    private String qq;

    private String studyType;

    private String enrollment;

    private String graduateSchool;

    private String studentNum;

    private String dailyLink;

    private String wish;

    private String checkBro;

    private String knowWay;
    public Integer getSHOW_ITEMS() {
        return SHOW_ITEMS;
    }

    public void setSHOW_ITEMS(Integer SHOW_ITEMS) {
        this.SHOW_ITEMS = SHOW_ITEMS;
    }

    private Integer SHOW_ITEMS;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType == null ? null : studyType.trim();
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment == null ? null : enrollment.trim();
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool == null ? null : graduateSchool.trim();
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum == null ? null : studentNum.trim();
    }

    public String getDailyLink() {
        return dailyLink;
    }

    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink == null ? null : dailyLink.trim();
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish == null ? null : wish.trim();
    }

    public String getCheckBro() {
        return checkBro;
    }

    public void setCheckBro(String checkBro) {
        this.checkBro = checkBro == null ? null : checkBro.trim();
    }

    public String getKnowWay() {
        return knowWay;
    }

    public void setKnowWay(String knowWay) {
        this.knowWay = knowWay == null ? null : knowWay.trim();
    }
}