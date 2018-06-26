package com.jdbctemplate.pojo;

public class Person {

    private int id;
    private long create_at;
    private long update_at;
    private String name;
    private int age;
    private int sex;
    private int tell;
    private int qq;
    private String email;
    private int stu_num;
    private String pro;
    private String waikey;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getTell() {
        return tell;
    }

    public void setTell(int tell) {
        this.tell = tell;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStu_num() {
        return stu_num;
    }

    public void setStu_num(int stu_num) {
        this.stu_num = stu_num;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getWaikey() {
        return waikey;
    }

    public void setWaikey(String waikey) {
        this.waikey = waikey;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", tell=" + tell +
                ", qq=" + qq +
                ", email='" + email + '\'' +
                ", stu_num=" + stu_num +
                ", pro='" + pro + '\'' +
                ", waikey='" + waikey + '\'' +
                '}';
    }
}
