package com.ptteng.dao;

import com.ptteng.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    long insertStudent(Student student);

    List<Student> findAll();

    boolean updateStudent(Student student);

    boolean deleteStudent(long id);

    Student findById(long id);

    long count();

    List<Student> findPage(long pageStart);
}
