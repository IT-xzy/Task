package com.task.dao;

import com.task.entity.Student;
import com.task.util.StudentPage;

import java.util.List;

public interface StudentDao {

    List<Student> findById(int id);
    List<Student> findByName(String name);
    List<Student> findByNumber(int number);

    void delete(int id);

    List<Student> findByPage(StudentPage studentPage);

    int total();
}



