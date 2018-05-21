package com.wyq.taskSeven.pojo;

public class Student {
    private Long studentId;

    private String studentName;

    private Long studentQq;

    private String studentMajor;

    private Long studentAdmissionTime;

    private String studentGraduatedSchool;

    private String studentOnlineId;

    private String studentDailyLinks;

    private String studentWishing;

    private String studentCounselingBrother;

    private String studentWhereKnow;

    private String studentPortrait;

    private Long studentPhone;

    private String studentEmail;

    private String studentPassword;

    private Long createAt;

    private Long updateAt;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public Long getStudentQq() {
        return studentQq;
    }

    public void setStudentQq(Long studentQq) {
        this.studentQq = studentQq;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor == null ? null : studentMajor.trim();
    }

    public Long getStudentAdmissionTime() {
        return studentAdmissionTime;
    }

    public void setStudentAdmissionTime(Long studentAdmissionTime) {
        this.studentAdmissionTime = studentAdmissionTime;
    }

    public String getStudentGraduatedSchool() {
        return studentGraduatedSchool;
    }

    public void setStudentGraduatedSchool(String studentGraduatedSchool) {
        this.studentGraduatedSchool = studentGraduatedSchool == null ? null : studentGraduatedSchool.trim();
    }

    public String getStudentOnlineId() {
        return studentOnlineId;
    }

    public void setStudentOnlineId(String studentOnlineId) {
        this.studentOnlineId = studentOnlineId == null ? null : studentOnlineId.trim();
    }

    public String getStudentDailyLinks() {
        return studentDailyLinks;
    }

    public void setStudentDailyLinks(String studentDailyLinks) {
        this.studentDailyLinks = studentDailyLinks == null ? null : studentDailyLinks.trim();
    }

    public String getStudentWishing() {
        return studentWishing;
    }

    public void setStudentWishing(String studentWishing) {
        this.studentWishing = studentWishing == null ? null : studentWishing.trim();
    }

    public String getStudentCounselingBrother() {
        return studentCounselingBrother;
    }

    public void setStudentCounselingBrother(String studentCounselingBrother) {
        this.studentCounselingBrother = studentCounselingBrother == null ? null : studentCounselingBrother.trim();
    }

    public String getStudentWhereKnow() {
        return studentWhereKnow;
    }

    public void setStudentWhereKnow(String studentWhereKnow) {
        this.studentWhereKnow = studentWhereKnow == null ? null : studentWhereKnow.trim();
    }

    public String getStudentPortrait() {
        return studentPortrait;
    }

    public void setStudentPortrait(String studentPortrait) {
        this.studentPortrait = studentPortrait == null ? null : studentPortrait.trim();
    }

    public Long getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(Long studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail == null ? null : studentEmail.trim();
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword == null ? null : studentPassword.trim();
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