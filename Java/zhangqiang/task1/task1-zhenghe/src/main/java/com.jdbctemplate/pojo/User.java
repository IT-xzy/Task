package com.jdbctemplate.pojo;

public class User {

    private int id;
    private long create_at;
    private long update_at;
    private String name;
    private String school;
    private int stu_num;
    private int type;
    private int qq;
    private int age;
    private int sex;
    private String pro;
    private String daily_link;
    private String brother;
    private String start_time;

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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getStu_num() {
        return stu_num;
    }

    public void setStu_num(int stu_num) {
        this.stu_num = stu_num;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
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

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getDaily_link() {
        return daily_link;
    }

    public void setDaily_link(String daily_link) {
        this.daily_link = daily_link;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", stu_num='" + stu_num + '\'' +
                ", type=" + type +
                ", qq=" + qq +
                ", age=" + age +
                ", sex=" + sex +
                ", pro='" + pro + '\'' +
                ", daily_link='" + daily_link + '\'' +
                ", brother='" + brother + '\'' +
                ", start_time='" + start_time + '\'' +
                '}';
    }


}
