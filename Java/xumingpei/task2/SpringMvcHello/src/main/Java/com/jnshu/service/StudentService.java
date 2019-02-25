package com.jnshu.service;

import com.jnshu.pojo.Page;
import com.jnshu.pojo.Student;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/1/7 - 22:07
 */
public interface StudentService {
    int total();
    int add(Student student);
    int delete(int id);
    int update(Student student);
    Student get(int id);
    List<Student> findAll();
    List<Student> list(Page page);
    List<Student> byName(String name);
}
