package com.longhang.stuDao;

import com.longhang.stuModel.Student;

import java.util.List;

public interface StudentDao
{

    void insert(Student student);
    boolean update(Student student);
    boolean delete(Long id);
    Student select(Long id);
    Student selects(Student student);
    List<Student> getAll() ;
}
