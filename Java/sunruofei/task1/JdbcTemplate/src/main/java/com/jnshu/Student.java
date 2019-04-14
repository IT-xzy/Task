package com.jnshu;

public class Student {
    private int id;
    private String name;
    private long qq;
    private String type;
    private String admission_date;
    private String graduate_school;
    private int student_number;
    private String daily_link;
    private String wish;
    private String instructor;
    private String information_source;

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

    public long getQq() {
        return qq;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdmission_date() {
        return admission_date;
    }

    public void setAdmission_date(String admission_date) {
        this.admission_date = admission_date;
    }

    public String getGraduate_school() {
        return graduate_school;
    }

    public void setGraduate_school(String graduate_school) {
        this.graduate_school = graduate_school;
    }

    public int getStudent_number() {
        return student_number;
    }

    public void setStudent_number(int student_number) {
        this.student_number = student_number;
    }

    public String getDaily_link() {
        return daily_link;
    }

    public void setDaily_link(String daily_link) {
        this.daily_link = daily_link;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getInformation_source() {
        return information_source;
    }

    public void setInformation_source(String information_source) {
        this.information_source = information_source;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq=" + qq +
                ", type='" + type + '\'' +
                ", admission_date='" + admission_date + '\'' +
                ", graduate_school='" + graduate_school + '\'' +
                ", student_number=" + student_number +
                ", daily_link='" + daily_link + '\'' +
                ", wish='" + wish + '\'' +
                ", instructor='" + instructor + '\'' +
                ", information_source='" + information_source + '\'' +
                '}';
    }
}


