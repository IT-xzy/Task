package com.restful.service;

import com.restful.model.Page;
import com.restful.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student selectById(int id);

    List<Student> findByStudent(Student student);

    int selectConut();

    Page<Student> findByPage(int count, int psize);

    int insertOne(Student student);

    int insertForList(List<Student> list);

    int deleteOne(int id);

    int deleteForList(List list);

    int updateOne(Student student);

    int updateForList(List<Student> list);
}
