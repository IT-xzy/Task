package com.myspring.di.properties;

import lombok.*;

/**
 * @author Arike
 * Create_at 2017/11/29 17:40
 */
@Data
public class StudentSetterImpl implements IStudent {
    private String name;
    private int age;
    private String gender;
    private double money;
    public void show(){
        System.out.println(name+age+gender+money+"天秀");
    }
    
/*    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setMoney(double money) {
        this.money = money;
    }*/
}
