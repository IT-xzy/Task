package com.ptteng.dao;

import com.ptteng.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentDao {
    int add(Student student);
    boolean delete(int id);
    boolean update(Student student);
    List<Student> findAll();
    Student findById(int id);
    int findRow();
    List<Student> findData(@Param("startNum")int first, @Param("endNum")int second);
}
