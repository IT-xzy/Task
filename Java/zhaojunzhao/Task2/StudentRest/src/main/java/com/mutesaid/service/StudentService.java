package com.mutesaid.service;

import com.mutesaid.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getStudent();

    Student getById(Long id);

    Boolean deleteStudent(Long id);

    Long addStudent(Student stu);

    Boolean updateStudent(Long id, String key, Object value);
}
