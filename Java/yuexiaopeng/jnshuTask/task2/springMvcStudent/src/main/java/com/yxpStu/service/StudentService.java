package com.yxpStu.service;

import com.yxpStu.pojo.Student;

import java.util.List;

public interface StudentService
{
    int insertStudent(Student student);

    void deleteStudent(Student student);

    int updateStudent(Student student);

    Student selectStudent(Student student);

    List<Student> selectAllStudent();

}

