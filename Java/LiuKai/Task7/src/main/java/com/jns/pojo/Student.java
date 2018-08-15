package com.jns.pojo;

public class Student {

    private Integer stuID;
    private String stuName;
    private String passWord;
    private String stuImage;
    private String course;
    private boolean good;
    private Long createTime;
    private Long updateTime;
    private Long loginTime;
    private String job;
    private String selfIntro;
    private  String phoneNum;
    private  String emailAddress;
    private  boolean emailActived;
    public Student(){}

    @Override
    public String toString() {
        return "学员[id]"+stuID+
                " 姓名"+stuName+
                " password"+passWord+
                " good"+good+
                " job"+job+
                " selfinfo"+selfIntro+
                " course"+course+
                " createat"+createTime+
                " update"+updateTime+
                "]";
    }

    public Integer getStuID() {
        return stuID;
    }

    public Student setStuID(Integer stuID) {
        this.stuID = stuID;
        return this;
    }

    public String getStuName() {
        return stuName;
    }

    public Student setStuName(String stuName) {
        this.stuName = stuName;
        return this;
    }

    public String getPassWord() {
        return passWord;
    }

    public Student setPassWord(String passWord) {
        this.passWord = passWord;
        return this;
    }

    public String getStuImage() {
        return stuImage;
    }

    public Student setStuImage(String stuImage) {
        this.stuImage = stuImage;
        return this;
    }

    public String getCourse() {
        return course;
    }

    public Student setCourse(String course) {
        this.course = course;
        return this;
    }

    public boolean isGood() {
        return good;
    }

    public Student setGood(boolean good) {
        this.good = good;
        return this;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public Student setCreateTime(Long createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public Student setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public Student setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
        return this;
    }

    public String getJob() {
        return job;
    }

    public Student setJob(String job) {
        this.job = job;
        return this;
    }

    public String getSelfIntro() {
        return selfIntro;
    }

    public Student setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro;
        return this;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public Student setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Student setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public boolean isEmailActived() {
        return emailActived;
    }

    public Student setEmailActived(boolean emailActived) {
        this.emailActived = emailActived;
        return this;
    }
}
