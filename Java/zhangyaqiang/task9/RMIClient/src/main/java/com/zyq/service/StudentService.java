package com.zyq.service;

import com.zyq.pojo.Page;
import com.zyq.pojo.Student;

public interface StudentService {
    Student insert(Student student);

    Page<Student> selectAllByPage(Integer currPage, Integer pageSize);

    Page<Student> selectAllByPage(Integer currPage);

    Student selectById(Long id);

    void updateById(Student student);

    void deleteById(Long id);

    Page<Student> selectByNum(Integer number, Integer currPage);

    Page<Student> selectByName(String name, Integer currPage);

    Page<Student> selectByNameAndNum(String name, Integer number, Integer currPage);
}
