package com.service;


import com.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findStudent();
    Long countStudent(Integer classifyId);
}
