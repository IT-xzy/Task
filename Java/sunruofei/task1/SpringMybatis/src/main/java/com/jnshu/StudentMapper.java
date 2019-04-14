package com.jnshu;

import com.jnshu.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface StudentMapper {

    int add(Student student);
    boolean delete(int id);
    boolean update(Student student);
    List<Student> findAll();
    Student findById(int id);


}
