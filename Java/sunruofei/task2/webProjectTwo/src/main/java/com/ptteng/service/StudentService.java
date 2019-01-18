package com.ptteng.service;

import com.ptteng.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    int add(Student student);
    boolean delete(int id);
    boolean update(Student student);
    List<Student> findAll();
    Student findById(int id);
    int findRow();
    List<Student> findData(@Param("startNum")int first, @Param("endNum")int second);
}
