package com.jnshu.dao;


import com.jnshu.pojo.Student;
import java.util.List;

public interface StudentDao {
    Student getStudentById(int i);
    Student getStudentByName(String name);
    boolean addStudent(Student user);
    boolean updataStudent(Student user);
    boolean deleteStudent(int UserId);
    List<Student> allStudent();
}
