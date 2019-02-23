package com.ptteng.service;

import com.ptteng.entity.Student;

import java.util.List;

public interface StudentService {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectAll();

    List<Student> selectBySalary(Long figure);

    int selectCount();

    int selectCountBySalary(Long income);

}
