package com.longhang.Task2.dao;

import com.longhang.Task2.model.Student;

import java.util.List;

public interface StudentDao {
    int insert(Student student);
    int update(Student student) ;
    int delete(Long id);
    Student select(Long id);
    List<Student> getAll() ;
}
