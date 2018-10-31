package com.jnshu.server.dao;

import com.jnshu.server.po.Students;

import java.util.List;

public interface StudentsDao {
    long insertStudents(Students students);
    int deleteStudents(long id);
    int updateStudents(Students students);
    int updateOne(Students students);
    Students selectStudents(long id);
    List selectIf(Students students);
    long insertBatch(Students[] students);
}