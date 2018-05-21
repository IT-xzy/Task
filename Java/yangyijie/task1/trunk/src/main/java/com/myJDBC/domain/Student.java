package com.myJDBC.domain;

import lombok.Data;

/**
 * @author Arike
 * Create_at  2017/11/14 9:21
 */
@Data
public class Student {
    private long id;
    private String name;
    private int age;
    
    public Long getId() {
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
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public Student() {
    }
    
    public Student(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
