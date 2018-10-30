package com.ptteng.dao;


import com.ptteng.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    List<Student> findStudent();
    Long countStudent(Integer classifyId);
}
