package com.ptt.mapper;

import com.ptt.pojo.Student;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student selectByName(String name);

    void deleteByName(String name);

    void updateByName(Student student);

    List<Student> selectAll();

    String selectEmail(String email);//判断email是否存在

    String selectTel(Long tel);//判断tel是否存在
    String selectName(String name);//判断name是否存在
}