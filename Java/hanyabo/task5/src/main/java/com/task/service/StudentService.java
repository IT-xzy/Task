package com.task.service;

import com.task.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findById(int id);
    List<Student> findByName(String name);
    List<Student> findByNumber(int number);
    void delete(Student student);
}
