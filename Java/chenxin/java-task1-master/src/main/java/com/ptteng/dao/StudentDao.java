package com.ptteng.dao;

import com.ptteng.model.Student;

import java.util.List;

public interface StudentDao {

    boolean saveStudent(Student student) throws Exception;

    boolean removeStudent(String name) throws Exception;

    boolean updateStudent(Student student) throws Exception;

    Student getStudentById(Long id) throws Exception;

    List<Student> listStudentByName(String name) throws Exception;

    List<Student> getStudentByNumber(String number) throws Exception;
}