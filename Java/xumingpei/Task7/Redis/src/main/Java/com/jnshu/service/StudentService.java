package com.jnshu.service;

import com.jnshu.pojo.Student;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/30 - 5:49
 */
public interface StudentService {
    int insertSelective(Student record);

    List<Student> getAll();

    //新增学生
    int insert(Student recond);
    //删除
    int deleteStudent(Long id);
    //更新
    int updateByPrimaryKey(Student recond);

    List<Student> selectByName(String name);

    Student selectByPrimaryKey(Long id);
}
