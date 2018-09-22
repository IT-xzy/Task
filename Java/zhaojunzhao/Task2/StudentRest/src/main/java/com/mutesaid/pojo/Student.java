package com.mutesaid.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Student {
    private Long id;

    @NotBlank(message = "student.name.null")
    private String name;

    @NotNull(message = "student.qq.null")
    private Long qq;

    @NotBlank(message = "student.type.null")
    private String type;

    @Pattern(regexp = "((((19|20)\\d{2})-(0?(1|[3-9])|1[012])-(0?[1-9]|[12]\\d|30))|(((19|20)\\d{2})-(0?[13578]|1[02])-31)|(((19|20)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|((((19|20)([13579][26]|[2468][048]|0[48]))|(2000))-0?2-29))$",message = "time.format.error")
    @NotBlank(message = "student.time.null")
    private String timeOf;

    @NotBlank(message = "student.school.null")
    private String gradeSchool;

    @NotBlank(message = "student.onlineid.null")
    private String onlineId;

    @NotBlank(message = "student.link.null")
    private String link;

    @NotBlank(message = "student.wish.null")
    private String wish;

    @NotBlank(message = "student.fellow.null")
    private String fellow;

    @NotBlank(message = "student.understand.null")
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