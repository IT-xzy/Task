package com.ev.model;

public class Student {

    public Student() {
    }

    //学员ID
    private Long id;
    //记录创建时间
    private Long createAt;
    //记录更新时间
    private Long updateAt;
    //学员姓名
    private String name;
    //学员性别
    private String gender;
    //学院年龄
    private int age;
    //学员qq
    private String qq;
    //学员学习方向
    private String occupation;
    //加入时间
    private String joinDate;
    //学校
    private String school;
    //学员学号
    private String number;
    //日报连接
    private String dailyUrl;
    //立愿
    private String declaration;
    //指导师兄
    private String consoler;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDailyUrl() {
        return dailyUrl;
    }

    public void setDailyUrl(String dailyUrl) {
        this.dailyUrl = dailyUrl;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getConsoler() {
        return consoler;
    }

    public void setConsoler(String consoler) {
        this.consoler = consoler;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", qq='" + qq + '\'' +
                ", occupation='" + occupation + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", school='" + school + '\'' +
                ", number='" + number + '\'' +
                ", dailyUrl='" + dailyUrl + '\'' +
                ", declaration='" + declaration + '\'' +
                ", consoler='" + consoler + '\'' +
                '}';
    }
}
