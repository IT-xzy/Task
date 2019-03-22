package com.jnshu.rmi.service;

import com.jnshu.rmi.beans.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAllStu();

    public Student findStuById(Long id);

}
