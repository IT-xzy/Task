package com.service;

import com.util.Page;
import com.model.Student;

import java.util.List;

public interface StudentService {

    void deleteStudentById(int id);

    List<Student> getAllStudentList();

    Student getStudentById(int id);

    void insertStudent(Student student);

    void updateStudent(Student student);

    int getTotal();

    List<Student> getStudentListByPage(Page page);
}
