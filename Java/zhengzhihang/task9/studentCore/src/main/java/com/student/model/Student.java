package com.student.model;

import java.io.Serializable;

public class Student implements Serializable {
    private Long id;

    private Long createAt;

    private Long updateAt;

    private String name;

    private String sex;

    private String qq;

    private String major;

    private Long entryTime;

    private String cellphone;

    private String email;

    private String headPortrait;

    private String comeFrom;

    private String salt;

    private String password;

    private String intro;

    private Integer activated;

    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

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
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Long entryTime) {
        this.entryTime = entryTime;
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom == null ? null : comeFrom.trim();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellPhone) {
        this.cellphone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", qq='" + qq + '\'' +
                ", major='" + major + '\'' +
                ", entryTime=" + entryTime +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", comeFrom='" + comeFrom + '\'' +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                ", intro='" + intro + '\'' +
                ", activated='" + activated + '\'' +
                '}';
    }
}