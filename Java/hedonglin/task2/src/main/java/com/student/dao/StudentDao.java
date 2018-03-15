package com.student.dao;

import com.student.model.Student;

import java.util.List;

public interface StudentDao {
    int deleteByPrimaryKey(Long id);

    int insert(Student student);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student student);

    List<Student> getAll();
}