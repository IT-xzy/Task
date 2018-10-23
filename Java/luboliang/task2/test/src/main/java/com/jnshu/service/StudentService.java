package com.jnshu.service;

import com.jnshu.model.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentService  {
    long addStudent(Student student);
    int  deleteStudent(long id);
    boolean  updateStudent(Student student);
    Student findById(long id);
    List<Student> findAll();
    @Select("select id from test")
    List<Student> findUsers() throws Exception;

    @Select("select * from test limit #{start},#{perPageUsers}")
    List<Student> findUsersByPage(@Param("start") int start, @Param("perPageUsers") int perPageUsers) throws Exception;
}
