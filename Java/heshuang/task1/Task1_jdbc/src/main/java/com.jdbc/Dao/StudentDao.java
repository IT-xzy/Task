package com.jdbc.Dao;
import com.jdbc.Pojo.Student;

import java.sql.ResultSet;

public interface StudentDao {
    void addStudent(Student student);
    boolean deleteStudent(int id);
    boolean updateStudent(int id);
    ResultSet findStudent(String name);
    ResultSet findAll();
    ResultSet findStudentByOlin_id(int online_id);
}
