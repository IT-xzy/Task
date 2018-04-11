package com.jnshu.model;
import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = -3896605600471191953L;
    private Integer id;

    private String name;

    private String qq;

    private String type;

    private String enrolmenttime;

    private String graduated;

    private String number;

    private String daily;

    private String ambition;

    private String responsible;

    private String wfrom;

    private String telipone;

    private String email;

    private String portrait;

    private Long createAt;

    private Long updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getEnrolmenttime() {
        return enrolmenttime;
    }

    public void setEnrolmenttime(String enrolmenttime) {
        this.enrolmenttime = enrolmenttime == null ? null : enrolmenttime.trim();
    }

    public String getGraduated() {
        return graduated;
    }

    public void setGraduated(String graduated) {
        this.graduated = graduated == null ? null : graduated.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily == null ? null : daily.trim();
    }

    public String getAmbition() {
        return ambition;
    }

    public void setAmbition(String ambition) {
        this.ambition = ambition == null ? null : ambition.trim();
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible == null ? null : responsible.trim();
    }

    public String getWfrom() {
        return wfrom;
    }

    public void setWfrom(String wfrom) {
        this.wfrom = wfrom == null ? null : wfrom.trim();
    }

    public String getTelipone() {
        return telipone;
    }

    public void setTelipone(String telipone) {
        this.telipone = telipone == null ? null : telipone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait == null ? null : portrait.trim();
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
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", qq='" + qq + '\'' + ", type='" + type + '\'' + ", enrolmenttime='" + enrolmenttime + '\'' + ", graduated='" + graduated + '\'' + ", number='" + number + '\'' + ", daily='" + daily + '\'' + ", ambition='" + ambition + '\'' + ", responsible='" + responsible + '\'' + ", wfrom='" + wfrom + '\'' + ", telipone='" + telipone + '\'' + ", email='" + email + '\'' + ", portrait='" + portrait + '\'' + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }
}