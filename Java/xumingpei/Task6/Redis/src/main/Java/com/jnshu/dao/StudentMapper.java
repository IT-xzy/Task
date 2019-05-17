package com.jnshu.dao;

import com.jnshu.pojo.Student;

import java.util.List;

public interface StudentMapper {
    int insertSelective(Student record);

    List<Student> getAll();

    List<Student> selectByName(String name);


    int insert(Student recond);

    Student selectByPrimaryKey(Long id);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(Student recond);
}