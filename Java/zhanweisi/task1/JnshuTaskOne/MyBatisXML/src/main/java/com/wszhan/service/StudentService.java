package com.wszhan.service;

import com.wszhan.pojo.Student;

import java.util.List;

/**
 * @author Weisi Zhan
 * @create 2018-10-31 10:24
 **/
public interface StudentService {
    Student select(int id) throws Exception;

    int insert(Student student) throws Exception;

    boolean update(Student student) throws Exception;

    boolean delete(int id) throws Exception;

    List<Student> selectAll() throws Exception;
}
