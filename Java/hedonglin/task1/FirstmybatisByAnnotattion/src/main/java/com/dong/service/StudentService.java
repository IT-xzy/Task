package com.dong.service;

import com.dong.model.Student;

import java.util.List;


public interface StudentService {

    List<Student> selectStudent();

   Student selectStudentByStudentId(Integer studentId);

    Student selectStudentByStudentName(String studentName);

    void insertStudent(Student student);

    void deleteStudentById(Integer id);

    void updateStudent(Student student);





}
