package com.alibaba.model;

public class Student {
    private Long id;

    private String name;
    private String qq;
    private String major;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {

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
    public String getMajor() {

        return major;
    }
    public void setMajor(String major) {

        this.major = major;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq=" + qq +
                ", major='" + major + '\'' +
                '}';
    }

}
