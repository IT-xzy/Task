package com.alibaba.service;

import com.alibaba.model.Student;

import java.util.List;

public interface StudentService {
   // public void deleteByPrimaryKey(int id);
   // int insert(Student student);
    //Student selectByPrimaryKey(int id);
    //public int updateByPrimaryKey(Student student);
   // List<Student> list();

    public void deleteByPrimaryKey(Long id);
    int insert(Student student);
    public boolean updateByPrimaryKey(Student student);
    Student selectByPrimaryKey(Long id);
    List<Student> list();
    Student selectById(Long id);


}


