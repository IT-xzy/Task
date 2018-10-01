package com.jnshu.mapper;

import com.jnshu.entity.Student;

import java.util.List;

public interface StudentDao {

    //获取student全部信息

    List<Student> findAll();

}
