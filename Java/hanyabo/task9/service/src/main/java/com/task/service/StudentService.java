package com.task.service;

import com.task.entity.Student;
import com.task.util.StudentPage;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;


@Remotable
public interface StudentService {

    List<Student> findById(int id);
    List<Student> findByName(String name);
    List<Student> findByNumber(int number);
    void delete(Student student);

    List<Student> findByPage(StudentPage studentpage);

    int total();
}
