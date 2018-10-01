package com.alibaba.model;

public class Excellent {
    private Integer id;
    private  String name;
    private String coding;
    private String duty;
    private String introduction;

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
        this.name = name;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Excellent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coding='" + coding + '\'' +
                ", duty='" + duty + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
