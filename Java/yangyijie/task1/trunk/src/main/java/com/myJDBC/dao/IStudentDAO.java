package com.myJDBC.dao;

import com.myJDBC.domain.Student;

import java.util.List;

/**
 * @author Arike
 * Create_at  2017/11/14 9:26
 */
public interface IStudentDAO {
    //增
    void add(Student stu);
    //删
    void delete(long id);
    //改
    void update(Student stu);
    //查
    Student get(long id);
    
    List<Student> getall();
    
}
