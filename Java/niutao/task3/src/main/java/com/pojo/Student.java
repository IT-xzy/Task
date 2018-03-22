package com.pojo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class Student {
    private int id ;
    private String name;
    private String qq;
    private int class_id;
    private String graduate_school;
    private String oline_number;
    private String link;
    private String wish;
    private int brother_id;


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

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getGraduate_school() {
        return graduate_school;
    }

    public void setGraduate_school(String graduate_school) {
        this.graduate_school = graduate_school;
    }

    public String getOline_number() {
        return oline_number;
    }

    public void setOline_number(String online_number) {
        this.oline_number = online_number;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public int getBrother_id() {
        return brother_id;
    }

    public void setBrother_id(int brother_id) {
        this.brother_id = brother_id;
    }

    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", class_id=" + class_id +
                ", graduate_school='" + graduate_school + '\'' +
                ", oline_number='" + oline_number + '\'' +
                ", link='" + link + '\'' +
                ", wish='" + wish + '\'' +
                ", brother_id=" + brother_id +
                '}';
    }
}
