package com.wszhan.service;

import com.wszhan.pojo.Student;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Weisi Zhan
 * @create 2018-10-31 15:30
 **/
public interface StudentJDBCTemplate {
    void setDataSource(DataSource dataSource);

    int create(String name, Integer age);

    void insertByBatch(final List<Student> students);

    List<Student> listStudents();

    void update(Student student);

    Student getStudent(Integer id);

    void delete(Integer id);
}
