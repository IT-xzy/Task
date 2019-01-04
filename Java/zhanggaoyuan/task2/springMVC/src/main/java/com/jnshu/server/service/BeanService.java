package com.jnshu.server.service;

import com.jnshu.server.po.Students;

import java.util.List;
import java.util.Map;

public interface BeanService {

    long insertStudents(Students students);
    boolean deleteStudents(long id);
    boolean updateOneStudents(Students students);
    boolean update(Students students);
    Students selectStudents(long id);
    List selectIf(Students students);
    long batchInsert(Students[] students);
    List selectAll();
//    List<Students> selectInfoByMap(Map<String,Object> map);
}
