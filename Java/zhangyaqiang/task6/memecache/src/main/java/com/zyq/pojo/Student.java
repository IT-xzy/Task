package com.zyq.pojo;


import java.io.Serializable;

public class Student implements Serializable {
    private Long id;
    private String name;
    private Integer qq;

    private String profession;
    private String university;
    private Integer number;

    private String daily;
    private String senior;
    private String from;

    private Long createTime;
    private Long updateTime;

    public Student() {
    }

    public Student(Long id, String name, Integer qq, String profession, String university, Integer number, String daily, String senior, String from, Long createTime, Long updateTime) {
        this.id = id;
        this.name = name;
        this.qq = qq;
        this.profession = profession;
        this.university = university;
        this.number = number;
        this.daily = daily;
        this.senior = senior;
        this.from = from;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq=" + qq +
                ", profession='" + profession + '\'' +
                ", university='" + university + '\'' +
                ", number=" + number +
                ", daily='" + daily + '\'' +
                ", senior='" + senior + '\'' +
                ", from='" + from + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

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

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public String getSenior() {
        return senior;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

}
