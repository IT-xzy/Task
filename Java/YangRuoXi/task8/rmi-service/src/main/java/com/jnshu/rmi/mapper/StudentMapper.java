package com.jnshu.rmi.mapper;

import com.jnshu.rmi.beans.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentMapper {

    Boolean insertStudent(Student student);

    List<Student> selectAllStudent();

    Student selectStudentById(Long id);

}
