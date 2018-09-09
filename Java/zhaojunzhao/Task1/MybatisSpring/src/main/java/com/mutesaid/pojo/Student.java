package com.mutesaid.pojo;

import java.util.Date;

public class Student {
    private Long id;

    private String name;

    private Long qq;

    private String type;

    private String timeOf;

    private String gradeSchool;

    private String onlineId;

    private String link;

    private String wish;

    private String fellow;

    private String understand;

    private Long createAt;

    private Long updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQq() {
        return qq;
    }

    public void setQq(Long qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimeOf() {
        return timeOf;
    }

    public void setTimeOf(String timeOf) {
        this.timeOf = timeOf;
    }

    public String getGradeSchool() {
        return gradeSchool;
    }

    public void setGradeSchool(String gradeSchool) {
        this.gradeSchool = gradeSchool;
    }

    public String getOnlineId() {
        return onlineId;
    }

    public void setOnlineId(String onlineId) {
        this.onlineId = onlineId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getFellow() {
        return fellow;
    }

    public void setFellow(String fellow) {
        this.fellow = fellow;
    }

    public String getUnderstand() {
        return understand;
    }

    public void setUnderstand(String understand) {
        this.understand = understand;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq=" + qq +
                ", type='" + type + '\'' +
                ", timeOf=" + timeOf +
                ", gradeSchool='" + gradeSchool + '\'' +
                ", onlineId='" + onlineId + '\'' +
                ", link='" + link + '\'' +
                ", wish='" + wish + '\'' +
                ", fellow='" + fellow + '\'' +
                ", understand='" + understand + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}