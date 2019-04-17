package com.jnshu.dao;

import com.jnshu.pojo.Student;

import java.util.List;

public interface StudentMapper {
    int insertSelective(Student record);

    List<Student> getAll();
}