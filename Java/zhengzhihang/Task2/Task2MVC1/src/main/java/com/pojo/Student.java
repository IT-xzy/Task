package com.pojo;

public class Student {
    private int id;
    private String age;
    private String sex;
    private String school;
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", school='" + school + '\'' +
                ", name='" + name + '\'' +
                '}'+"\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
