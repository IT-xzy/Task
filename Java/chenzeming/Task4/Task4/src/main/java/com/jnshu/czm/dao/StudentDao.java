package com.jnshu.czm.dao;

import com.jnshu.czm.model.Student;

import java.util.List;

public interface StudentDao {

    Student findById(Integer id);  //通过id查询

    List<Student> findAll();//查询全部用户

    int selectCount();//查询结业记录总数

    int selectAt();//查询在学记录总数

}
