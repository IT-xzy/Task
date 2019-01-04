package com.wszhan.pojo;

/**
 * @author Weisi Zhan
 * @create 2018-10-30 11:23
 **/
public class Student {
    private Integer age;
    private String  name;
    private Integer id;

    public void setAge(Integer age){
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }
}
