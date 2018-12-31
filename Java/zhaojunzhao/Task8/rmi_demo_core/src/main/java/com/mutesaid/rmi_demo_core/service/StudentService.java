package com.mutesaid.rmi_demo_core.service;

import com.mutesaid.rmi_demo_core.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> listStudentByQuery(String type, Long startAt, Long endAt);

    Student findById(Long id);

    Long saveStudent(Student stu);

    Long deleteStudent(Long id);

    Long updateStudent(Student stu);
}
