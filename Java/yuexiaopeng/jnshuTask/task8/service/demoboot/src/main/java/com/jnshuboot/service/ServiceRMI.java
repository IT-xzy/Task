package com.jnshuboot.service;

import com.jnshuboot.pojo.Student;

import java.util.List;


public interface ServiceRMI {

    List<Student> getStudent(int id);
}
