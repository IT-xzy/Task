package com.fml.pojo;

/**
 * @Description:
 * @ClassName:
 * @author: fml<duanweikai>
 * @date: 2018/3/10 13:21
 * @version: [1.0]
 */
public class Student {
    private int id;
    /**创建时间*/
    private long createTime;
    /**更新时间*/
    private long updateTime;
    /**学员姓名*/
    private String stuName;
    /**学员QQ*/
    private String QQ;
    /**课程类型,1代表web，2代表java*/
    private int lessonType;
    /**入学时间*/
    private long admissionTime;
    /**毕业院校*/
    private String graduatedSchool;
    /**线上ID*/
    private String stuNumber;
    /**日报链接*/
    private String diaryLink;
    /**入学愿望*/
    private String wish;
    /**师兄ID*/
    private int brotherId;
    /**信息来源*/
    private String heardFrom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public int getLessonType() {
        return lessonType;
    }

    public void setLessonType(int lessonType) {
        this.lessonType = lessonType;
    }

    public long getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(long admissionTime) {
        this.admissionTime = admissionTime;
    }

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getDiaryLink() {
        return diaryLink;
    }

    public void setDiaryLink(String diaryLink) {
        this.diaryLink = diaryLink;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public int getBrotherId() {
        return brotherId;
    }

    public void setBrotherId(int brotherId) {
        this.brotherId = brotherId;
    }

    public String getHeardFrom() {
        return heardFrom;
    }

    public void setHeardFrom(String heardFrom) {
        this.heardFrom = heardFrom;
    }
}
