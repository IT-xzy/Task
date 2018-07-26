package com.stu.service;

import com.stu.model.Page;
import com.stu.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService {

    Student findByID(int id);

    int findAllCount();

    List<Student> findAll();

    List<Student> findByStudent(Student student);

    Page<Student> findByPage(int nowpage, int pagesize);

    int insertOne(Student student);

    int updateOne(Student student);
    
    int updateHeadIcoById(Map<String,Object> map);

}
