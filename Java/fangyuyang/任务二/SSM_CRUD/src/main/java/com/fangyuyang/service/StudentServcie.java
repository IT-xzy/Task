package com.fangyuyang.service;

import com.fangyuyang.model.Student;

import java.util.List;

public interface StudentServcie {
    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int id);

    Student findStudentById(int id);

    List<Student> findAll();
}
