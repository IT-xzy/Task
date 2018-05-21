package com.dong.service;

import com.dong.model.Student;


public interface StudentService {
    Student selectStudentById(Integer id);

    Student selectStudentByStudentId(Integer studentId);

    Student selectStudentByStudentName(String studentName);

    int insertStudent(Student student);

    Integer deleteStudentById(Integer id);

    boolean updateStudent(Student student);
}
