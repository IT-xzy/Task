package com.how2java.service;

import com.how2java.pojo.Student;

import com.how2java.util.StudentPage;

import java.util.List;

public interface StudentService {

    List<Student> list();
    int total();
    List<Student> list(StudentPage studentpage);
    void add(Student student);
    void update(Student student);
    void delete(Student student);
    Student get(int id);
}
