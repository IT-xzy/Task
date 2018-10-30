package com.lihoo.jnshu.admin.domain;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lihoo
 * @since 2018-09-28
 */
public class StudentList implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String salt;

    private String pwd;

    private Long logAt;

    private Long expireAt;

    private String headImg;

    private String email;

    private String phone;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public Long getLogAt() {
        return logAt;
    }

    public void setLogAt(Long logAt) {
        this.logAt = logAt;
    }
    public Long getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Long expireAt) {
        this.expireAt = expireAt;
    }
    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    public String toString() {
        return "StudentList{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", salt='" + salt + '\'' +
                ", pwd='" + pwd + '\'' +
                ", logAt=" + logAt +
                ", expireAt=" + expireAt +
                ", headImg='" + headImg + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
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
