package com.jnshu.server.po;

public class Students {
    //    数据表的列属性和相应的get和set的方法
    private long id;
    private long createAt;
    private long updateAt;
    private String studentName;
    private String qq;
    private String profession;
    private String admissionDate;
    private String graduatedFrom;
    private String studentId;
    private String dailyLink;
    private String makeWishes;
    private String coachingSenior;
    private String approach;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getGraduatedFrom() {
        return graduatedFrom;
    }

    public void setGraduatedFrom(String graduatedFrom) {
        this.graduatedFrom = graduatedFrom;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDailyLink() {
        return dailyLink;
    }

    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink;
    }

    public String getMakeWishes() {
        return makeWishes;
    }

    public void setMakeWishes(String makeWishes) {
        this.makeWishes = makeWishes;
    }

    public String getCoachingSenior() {
        return coachingSenior;
    }

    public void setCoachingSenior(String coachingSenior) {
        this.coachingSenior = coachingSenior;
    }

    public String getApproach() {
        return approach;
    }

    public void setApproach(String approach) {
        this.approach = approach;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", studentName='" + studentName + '\'' +
                ", qq='" + qq + '\'' +
                ", profession='" + profession + '\'' +
                ", admissionDate='" + admissionDate + '\'' +
                ", graduatedFrom='" + graduatedFrom + '\'' +
                ", studentId='" + studentId + '\'' +
                ", dailyLink='" + dailyLink + '\'' +
                ", makeWishes='" + makeWishes + '\'' +
                ", coachingSenior='" + coachingSenior + '\'' +
                ", approach='" + approach + '\'' +
                '}';
    }
}
