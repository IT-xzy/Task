package com.putteng;

public class Student {

    private int id ;
    private String name;
    private String qq;
    private int classId;
    private String graduateSchool;
    private String olineNumber;
    private String link;
    private String wish;
    private int brotherId;


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

    public int getclassId() {
        return classId;
    }

    public void setclassId(int classId) {
        this.classId = classId;
    }

    public String getgraduateSchool() {
        return graduateSchool;
    }

    public void setgraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getolineNumber() {
        return olineNumber;
    }

    public void setolineNumber(String online_number) {
        this.olineNumber = online_number;
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

    public int getbrotherId() {
        return brotherId;
    }

    public void setbrotherId(int brotherId) {
        this.brotherId = brotherId;
    }

    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", classId=" + classId +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", olineNumber='" + olineNumber + '\'' +
                ", link='" + link + '\'' +
                ", wish='" + wish + '\'' +
                ", brotherId=" + brotherId +
                '}';
    }
}
