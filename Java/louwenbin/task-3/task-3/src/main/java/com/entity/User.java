
package com.entity;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String sex;
    private String qq;
    private String type;
    private String admission;
    private String graduate;
    private String link;
    private String wish;
    private String audit;
    private String understand;
    private Date create_at;
    private Date update_at;

    public String toString() {
        return "User{id=" + this.id + ", name='" + this.name + '\'' + ", sex='" + this.sex + '\'' + ", qq='" + this.qq + '\'' + ", type='" + this.type + '\'' + ", admission='" + this.admission + '\'' + ", graduate='" + this.graduate + '\'' + ", link='" + this.link + '\'' + ", wish='" + this.wish + '\'' + ", audit='" + this.audit + '\'' + ", understand='" + this.understand + '\'' + ", create_at=" + this.create_at + ", update_at=" + this.update_at + '}';
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getQq() {
        return this.qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdmission() {
        return this.admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getGraduate() {
        return this.graduate;
    }

    public void setGraduate(String graduate) {
        this.graduate = graduate;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getWish() {
        return this.wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getAudit() {
        return this.audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public String getUnderstand() {
        return this.understand;
    }

    public void setUnderstand(String understand) {
        this.understand = understand;
    }

    public Date getCreate_at() {
        return this.create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return this.update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }
}

