package com.mutesaid.bootdemo.service;

import com.mutesaid.bootdemo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> listStudentByQuery(String type, Long startAt, Long endAt);

    Student findById(Long id);

    Long saveStudent(Student stu);

    Long deleteStudent(Long id);

    Long updateStudent(Student stu);
}
