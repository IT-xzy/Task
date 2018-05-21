package com.ptteng.dao;

import com.ptteng.model.Student;

import java.util.List;

public interface StudentsDao {
    List<Student> getall() throws Exception;
}
