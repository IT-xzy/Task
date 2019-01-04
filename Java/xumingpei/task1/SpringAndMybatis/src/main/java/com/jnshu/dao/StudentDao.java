package com.jnshu.dao;

import com.jnshu.pojo.Student;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/1/2 - 23:20
 */
public interface StudentDao {
     void addStudent(Student student);
     int deleteStudent(int id);
     int updateStudent(Student student);
     Student findStudentById(int id);
     List<Student> findAll();
}
