package com.yxpStu.dao;

import com.yxpStu.pojo.Student;
import java.util.*;
public interface StudentDao
{
    int insertStudent(Student student);

    void deleteStudent(Student student);

    int updateStudent(Student student);

    Student selectStudent(Student student);

    List<Student> selectAllStudent();

}
