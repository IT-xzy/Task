package com.task1;

public class Student {
    private  long  id;
    private  long create_at;
    private  long update_at;
    private  String name;
    private  long qq;
    private  String curricular;
    private  String school_time;
    private  String college;
    private  String id_num;
    private  String report_link;
    private  String goal;
    private  String refree;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
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

    public String getCurricular() {
        return curricular;
    }

    public void setCurricular(String curricular) {
        this.curricular = curricular;
    }

    public String getSchool_time() {
        return school_time;
    }

    public void setSchool_time(String school_time) {
        this.school_time = school_time;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getId_num() {
        return id_num;
    }

    public void setId_num(String id_num) {
        this.id_num = id_num;
    }

    public String getReport_link() {
        return report_link;
    }

    public void setReport_link(String report_link) {
        this.report_link = report_link;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getRefree() {
        return refree;
    }

    public void setRefree(String refree) {
        this.refree = refree;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", name='" + name + '\'' +
                ", qq=" + qq +
                ", curricular='" + curricular + '\'' +
                ", school_time='" + school_time + '\'' +
                ", college='" + college + '\'' +
                ", id_num='" + id_num + '\'' +
                ", report_link='" + report_link + '\'' +
                ", goal='" + goal + '\'' +
                ", refree='" + refree + '\'' +
                '}';
    }
}
