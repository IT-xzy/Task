package com.opt.service;

import com.opt.model.Page;
import com.opt.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    Student findByID(int id);

    int findAllCount();

    List<Student> findAll();

    List<Student> findByStudent(Student student);

    Page<Student> findByPage(int nowpage, int pagesize);

    int insertOne(Student student);

    int updateOne(Student student);

}
