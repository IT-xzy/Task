package com.ptteng.service;

import com.ptteng.model.Student;

import java.util.List;

public interface StudentService {

    boolean saveStudent(Student student) throws Exception;

    boolean removeStudent(String name) throws Exception;

    boolean updateStudent(Student student) throws Exception;

    Student getStudentById(Long id) throws Exception;

    List<Student> getStudentByName(String name) throws Exception;

    List<Student> getStudentByNumber(String name) throws Exception;
}