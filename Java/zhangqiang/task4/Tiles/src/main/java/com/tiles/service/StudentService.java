package com.tiles.service;

import com.tiles.model.Page;
import com.tiles.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface StudentService {

    Student findByID(int id);

    int findAllCount();

    List<Student> findAll();

    List<Student> findByStudent(Student student);

    Page<Student> findByPage(int nowpage,int pagesize);

    int insertOne(Student student);

}
