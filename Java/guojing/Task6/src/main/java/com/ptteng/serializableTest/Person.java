package com.ptteng.serializableTest;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 4107747888659447944L;
//  静态属性不能被序列化
    private static Long id = 11L;
    private String name;
    private Long age;
//    使用transient修饰的变量不能被序列化
    transient private String sex;
    private String addTip;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", id='" + id + '\'' +
                ", addTip='" + addTip + '\'' +
                '}';
    }

    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        Person.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddTip() {
        return addTip;
    }

    public void setAddTip(String addTip) {
        this.addTip = addTip;
    }


}