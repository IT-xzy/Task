package hzw.service;

import hzw.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;


public interface StudentSerivce {
    List<Student> getAll();

    void addStu(Student student);

    void deleteStu(long stuId);

    void updateStu(Student student);

    Student getId(long stuId);
}
