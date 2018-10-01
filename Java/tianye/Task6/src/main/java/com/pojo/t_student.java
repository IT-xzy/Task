package com.pojo;

import java.io.Serializable;

public class t_student implements Serializable {
    private int id;
    private String name;
    private String stuIntroduction;
    private String picture;
    private boolean ifWork;
    private boolean ifExcellent;
    private String profession;
    private Long create_at;
    private Long update_at;
    private String create_by;
    private String update_by;

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

    public String getStuIntroduction() {
        return stuIntroduction;
    }

    public void setStuIntroduction(String stuIntroduction) {
        this.stuIntroduction = stuIntroduction;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isIfWork() {
        return ifWork;
    }

    public void setIfWork(boolean ifWork) {
        this.ifWork = ifWork;
    }

    public boolean isIfExcellent() {
        return ifExcellent;
    }

    public void setIfExcellent(boolean ifExcellent) {
        this.ifExcellent = ifExcellent;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    @Override
    public String toString() {
        return "t_student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stuIntroduction='" + stuIntroduction + '\'' +
                ", picture='" + picture + '\'' +
                ", ifWork=" + ifWork +
                ", ifExcellent=" + ifExcellent +
                ", profession='" + profession + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", create_by='" + create_by + '\'' +
                ", update_by='" + update_by + '\'' +
                '}';
    }
}
