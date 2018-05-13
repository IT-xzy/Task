package com.alibaba.dao;


import com.alibaba.model.Student;

import java.util.List;

public interface StudentDao {

    public void deleteByPrimaryKey(Long id);
    Student selectByPrimaryKey(Long id);
    int insert(Student student);
    public boolean updateByPrimaryKey(Student student);
    List<Student> list();
    Student selectById(Long id);


}
