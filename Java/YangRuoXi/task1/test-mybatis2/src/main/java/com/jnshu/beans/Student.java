package com.jnshu.beans;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Student {
    private Integer id;
    private String name;
    private Integer qq;
    private String type;
    private String time;
    private String school;
    private Integer onlineNumber;
    private String link;
    private String wish;
    private String teacher;
    private String whereKonw;
    private Long createAt = System.currentTimeMillis();
    private Long updateAt = this.createAt;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq=" + qq +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", school='" + school + '\'' +
                ", onlineNumber=" + onlineNumber +
                ", link='" + link + '\'' +
                ", wish='" + wish + '\'' +
                ", teacher='" + teacher + '\'' +
                ", whereKonw='" + whereKonw + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }

    public void sayHello(){
        System.out.println("Hello");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getOnlineNumber() {
        return onlineNumber;
    }

    public void setOnlineNumber(Integer onlineNumber) {
        this.onlineNumber = onlineNumber;
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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getWhereKonw() {
        return whereKonw;
    }

    public void setWhereKonw(String whereKonw) {
        this.whereKonw = whereKonw;
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
}
