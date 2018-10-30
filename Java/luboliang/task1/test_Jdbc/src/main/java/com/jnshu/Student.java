package com.jnshu;

public class Student {
    private  long id ;
    private  String name ;
    private  long create_at;
    private  long update_at;
    private  long qq;
    private  String course_type;
    private  long entrance_time;
    private  String graduate_school;
    private  long wish;
    private  String daily_link;
    private  String set_to;
    private  String brother;
    private  String learn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getQq() {
        return qq;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public String getCourse_type() {
        return course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    public long getEntrance_time() {
        return entrance_time;
    }

    public void setEntrance_time(long entrance_time) {
        this.entrance_time = entrance_time;
    }

    public String getGraduate_school() {
        return graduate_school;
    }

    public void setGraduate_school(String graduate_school) {
        this.graduate_school = graduate_school;
    }

    public long getWish() {
        return wish;
    }

    public void setWish(long wish) {
        this.wish = wish;
    }

    public String getDaily_link() {
        return daily_link;
    }

    public void setDaily_link(String daily_link) {
        this.daily_link = daily_link;
    }

    public String getSet_to() {
        return set_to;
    }

    public void setSet_to(String set_to) {
        this.set_to = set_to;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getLearn() {
        return learn;
    }

    public void setLearn(String learn) {
        this.learn = learn;
    }

    @Override
    public String toString() {
        return "com.jnshu.Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", qq=" + qq +
                ", course_type='" + course_type + '\'' +
                ", entrance_time=" + entrance_time +
                ", graduate_school='" + graduate_school + '\'' +
                ", wish=" + wish +
                ", daily_link='" + daily_link + '\'' +
                ", set_to='" + set_to + '\'' +
                ", brother='" + brother + '\'' +
                ", learn='" + learn + '\n' +
                '}';
    }
}


