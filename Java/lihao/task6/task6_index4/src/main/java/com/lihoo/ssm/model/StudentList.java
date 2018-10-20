package com.lihoo.ssm.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author lihoo
 */
@SuppressWarnings("unused")
public class StudentList implements Serializable {

    private static final long serialVersionUID = 9174194101246733501L;

    private Long id;

    private String username;

    private Long qqNum;

    private String studyType;

    private Long studyTime;

    private String school;

    private String studyId;

    private String dailyLink;

    private String promise;

    private String teachBro;

    private String knowUsFrom;

    private Long createAt;

    private Long updateAt;

    public StudentList() {
    }

    public StudentList(Long id, String username, Long qqNum, String studyType, Long studyTime, String school, String studyId, String dailyLink, String promise, String teachBro, String knowUsFrom, Long createAt, Long updateAt) {
        this.id = id;
        this.username = username;
        this.qqNum = qqNum;
        this.studyType = studyType;
        this.studyTime = studyTime;
        this.school = school;
        this.studyId = studyId;
        this.dailyLink = dailyLink;
        this.promise = promise;
        this.teachBro = teachBro;
        this.knowUsFrom = knowUsFrom;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getQqNum() {
        return qqNum;
    }

    public void setQqNum(Long qqNum) {
        this.qqNum = qqNum;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public Long getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(Long studyTime) {
        this.studyTime = studyTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStudyId() {
        return studyId;
    }

    public void setStudyId(String studyId) {
        this.studyId = studyId;
    }

    public String getDailyLink() {
        return dailyLink;
    }

    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink;
    }

    public String getPromise() {
        return promise;
    }

    public void setPromise(String promise) {
        this.promise = promise;
    }

    public String getTeachBro() {
        return teachBro;
    }

    public void setTeachBro(String teachBro) {
        this.teachBro = teachBro;
    }

    public String getKnowUsFrom() {
        return knowUsFrom;
    }

    public void setKnowUsFrom(String knowUsFrom) {
        this.knowUsFrom = knowUsFrom;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StudentList)) {
            return false;
        }
        StudentList that = (StudentList) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(qqNum, that.qqNum) &&
                Objects.equals(studyType, that.studyType) &&
                Objects.equals(studyTime, that.studyTime) &&
                Objects.equals(school, that.school) &&
                Objects.equals(studyId, that.studyId) &&
                Objects.equals(dailyLink, that.dailyLink) &&
                Objects.equals(promise, that.promise) &&
                Objects.equals(teachBro, that.teachBro) &&
                Objects.equals(knowUsFrom, that.knowUsFrom) &&
                Objects.equals(createAt, that.createAt) &&
                Objects.equals(updateAt, that.updateAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, qqNum, studyType, studyTime, school, studyId, dailyLink, promise, teachBro, knowUsFrom, createAt, updateAt);
    }

    @Override
    public String toString() {
        return "StudentList{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", qqNum=" + qqNum +
                ", studyType='" + studyType + '\'' +
                ", studyTime=" + studyTime +
                ", school='" + school + '\'' +
                ", studyId='" + studyId + '\'' +
                ", dailyLink='" + dailyLink + '\'' +
                ", promise='" + promise + '\'' +
                ", teachBro='" + teachBro + '\'' +
                ", knowUsFrom='" + knowUsFrom + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}