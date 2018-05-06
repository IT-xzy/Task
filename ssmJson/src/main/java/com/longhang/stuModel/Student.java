package com.longhang.stuModel;

public class Student {
    private Long id;
    private String name;
    private String qq;
    private String wish;
    private Long create_at;
    private Long update_at;
    private String major;
    private String dairylink;


    public Student() {
    }
    public Student(Long id){
       this.id=id;
    }

    public Student(Long id, String name, String qq, String wish, String major, Long create_at, Long update_at, String dairylink) {
        this.id = id;
        this.name = name;
        this.qq = qq;
        this.wish = wish;
        this.major = major;
        this.create_at = create_at;
        this.update_at = update_at;
        this.dairylink = dairylink;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDairylink() {
        return dairylink;
    }

    public void setDairylink(String dairylink) {
        this.dairylink = dairylink;
    }

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

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", wish='" + wish + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", major='" + major + '\'' +
                ", dairylink='" + dairylink + '\'' +
                '}';
    }
}