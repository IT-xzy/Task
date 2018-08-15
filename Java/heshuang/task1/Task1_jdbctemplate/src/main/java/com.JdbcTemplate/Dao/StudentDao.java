package com.JdbcTemplate.Dao;
import com.JdbcTemplate.Pojo.Student;

import java.sql.ResultSet;
import java.util.List;

public interface StudentDao {
    Long Insert(Student student);
    boolean Delete(int id);
    boolean UpdateStudent(Student student);
    void findAllStudent();
    List<Student> findByName(String name);
    List<Student> findByOnlie_id(int online_id);
}
