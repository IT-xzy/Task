package com.jnshu.server.dao;

import org.springframework.stereotype.Repository;
import com.jnshu.server.po.Students;

import java.util.List;
import java.util.Map;

//@Repository用于标注数据访问组件，即DAO组件；
//@Service("studentsDao")
@Repository
public interface StudentsDao {
    long insertStudents(Students students);
    boolean deleteStudents(long id);
    boolean updateOneStudents(Students students);
    boolean update(Students students);
    Students selectStudents(long id);
    List selectIf(Students students);
    long insertBatch(Students[] students);
    List selectAll();
//    List<Students> selectInfoByMap(Map<String,Object> map);

}