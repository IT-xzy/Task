package com.fml.service;

import com.fml.pojo.Student;

import java.util.List;

public interface StudentService {
    boolean add(Student student);

    boolean deleteById(int id);

    boolean deleteAll();

    boolean update(Student student);

    Student getById(int id);

    List<Student> getByStatus(int status);

    int getTotalCount();

    int getWorkCount();

    List<Integer> getStudyCountByLesson();
    /*根据邮箱获取salt*/
    Student getStuByEmail(String email);
}
