package com.jnshu.dao;

import com.jnshu.pojo.Student;

import java.util.List;

/**
 * Demo interface
 *
 * @author pipiretrak
 * @date 2018/12/30 - 4:25
 */

public interface StudentDao {
    int addStudent(Student student) ;//增
    void deleteStudent(int id) ;//删
    void updateStudent(Student student);
    Student findByIdAndName(int id,String name);
    List<Student> findAll();
}
