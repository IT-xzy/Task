package com.myitschool.service;

import com.myitschool.student.Student;

import java.util.List;

public interface baseService {
    public List<Student> allStudent();
    public void insertStudent(Student student);
    public Student selectStudent(int id);
    public int deleteStudent(int id);
    public int updateStudent(Student student);
}
