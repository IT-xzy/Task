package com.mutesaid.service;

import com.mutesaid.model.Student;
import org.oasisopen.sca.annotation.Remotable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    List<Student> listStudentByQuery(String type, Long startAt, Long endAt);

    Student findById(Long id);

    Long saveStudent(Student stu);

    Long deleteStudent(Long id);

    Long updateStudent(Student stu);
}
