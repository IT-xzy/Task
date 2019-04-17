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
}
