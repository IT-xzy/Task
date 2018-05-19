package com.ssm.model;

import java.io.Serializable;

/**
 * Created by Enzo Cotter on 18/4/2.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -1624808335366033185L;
    private int id;
    private String name;
    private int number;
    private int qq;
    private String type;
    private String university;
    private Long time;
    private String daily_link;
    private String pledge;
    private String senior;
    private String locality;
    private Long cellphone;
    private String email;
    private String picture;
    private Long create_at;
    private Long update_at;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", qq=" + qq +
                ", type='" + type + '\'' +
                ", university='" + university + '\'' +
                ", time=" + time +
                ", daily_link='" + daily_link + '\'' +
                ", pledge='" + pledge + '\'' +
                ", senior='" + senior + '\'' +
                ", locality='" + locality + '\'' +
                ", cellphone=" + cellphone +
                ", email='" + email + '\'' +
                ", picture='" + picture + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getDaily_link() {
        return daily_link;
    }

    public void setDaily_link(String daily_link) {
        this.daily_link = daily_link;
    }

    public String getPledge() {
        return pledge;
    }

    public void setPledge(String pledge) {
        this.pledge = pledge;
    }

    public String getSenior() {
        return senior;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public void setCellphone(Long cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
}
