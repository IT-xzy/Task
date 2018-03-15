package com.myspring.di.properties;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @author Arike
 * Create_at 2017/11/29 19:00
 */
@AllArgsConstructor @ToString
public class StudentConstractorImpl implements IStudent {
    private String name;
    private int age;
    private String gender;
    private double money;
    private long time;
    
}
