package com.jnshu.pojo;

/**
 * @author pipiretrak
 * @date 2018/12/30 - 0:40
 */
public class Student {
    private int id;
    private String name;
    private String qq;
    private String type;
    private long enrolmentTime;
    private String school;
    private int onlineId;
    private String dailyUrl;
    private String wish;
    private String brother;
    private String whereToKnowJnshu;
    private long createAt;
    private long updateAt;

    /**
     * 无参构造
     */
    public Student(){

    }

    /**
     * 有参构造
     */
    public Student(int id, String name, String qq, String type,long enrolmentTime, String school, int onlineId, String dailyUrl, String wish, String brother, String whereToKnowJnshu, long createAt, long updateAt) {
        this.id = id;
        this.name = name;
        this.qq = qq;
        this.type = type;
        this.enrolmentTime = enrolmentTime;
        this.school = school;
        this.onlineId = onlineId;
        this.dailyUrl = dailyUrl;
        this.wish = wish;
        this.brother = brother;
        this.whereToKnowJnshu = whereToKnowJnshu;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getEnrolmentTime() {
        return enrolmentTime;
    }

    public void setEnrolmentTime(long enrolmentTime) {
        this.enrolmentTime = enrolmentTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getOnlineId() {
        return onlineId;
    }

    public void setOnlineId(int onlineId) {
        this.onlineId = onlineId;
    }

    public String getDailyUrl() {
        return dailyUrl;
    }

    public void setDailyUrl(String dailyUrl) {
        this.dailyUrl = dailyUrl;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getWhereToKnowJnshu() {
        return whereToKnowJnshu;
    }

    public void setWhereToKnowJnshu(String whereToKnowJnshu) {
        this.whereToKnowJnshu = whereToKnowJnshu;
    }

    public long getcreateAt() {
        return createAt;
    }

    public void setcreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getupdateAt() {
        return updateAt;
    }

    public void setupdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", type='" + type + '\'' +
                ", enrolmentTime=" + enrolmentTime +
                ", school='" + school + '\'' +
                ", onlineId=" + onlineId +
                ", dailyUrl='" + dailyUrl + '\'' +
                ", wish='" + wish + '\'' +
                ", brother='" + brother + '\'' +
                ", whereToKnowJnshu='" + whereToKnowJnshu + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
