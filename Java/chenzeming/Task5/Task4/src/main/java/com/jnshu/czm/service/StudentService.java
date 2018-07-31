package com.jnshu.czm.service;

import com.jnshu.czm.model.Student;

import java.util.List;

public interface StudentService {

    public Student findById(int studentId);

    public List<Student> findAll();


    public int selectCount();

    public int selectAt();
}
