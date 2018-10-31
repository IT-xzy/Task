package com.jnshu.server.dao;

import org.springframework.stereotype.Repository;
import com.jnshu.server.po.Students;

import java.util.List;

//@Repository用于标注数据访问组件，即DAO组件；
@Repository
public interface StudentsDao {
    long insertStudents(Students students);
    boolean deleteStudents(long id);
    boolean updateStudents(Students students);
    boolean updateOne(Students students);
    Students selectStudents(long id);
    List selectIf(Students students);
    long insertBatch(Students[] students);
}