package com.jnshu.server.service;

import com.jnshu.server.po.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface BeanService {

    long insertStudents(Students students);
    boolean deleteStudents(long id);
    boolean updateStudents(Students students);
    boolean updateOne(Students students);
    Students selectStudents(long id);
    List selectIf(Students students);
    long batchInsert(Students[] students);
}
