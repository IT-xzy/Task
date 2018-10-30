package com.jnshu.model;

public class Workss {
    private long id;
    private long create_at;
    private long update_at;
    private String works_name;
    private String works_introduction;
    private String works_class1;
    private String works_class2;
    private String works;

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

    public String getWorks_name() {
        return works_name;
    }

    public void setWorks_name(String works_name) {
        this.works_name = works_name;
    }

    public String getWorks_introduction() {
        return works_introduction;
    }

    public void setWorks_introduction(String works_cintroduction) {
        this.works_introduction = works_cintroduction;
    }

    public String getWorks_class1() {
        return works_class1;
    }

    public void setWorks_class1(String works_class1) {
        this.works_class1 = works_class1;
    }

    public String getWorks_class2() {
        return works_class2;
    }

    public void setWorks_class2(String works_class2) {
        this.works_class2 = works_class2;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }

    @Override
    public String toString() {
        return "Workss{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", works_name='" + works_name + '\'' +
                ", works_introduction='" + works_introduction + '\'' +
                ", works_class1='" + works_class1 + '\'' +
                ", works_class2='" + works_class2 + '\'' +
                ", works='" + works + '\'' +
                '}';
    }
}
