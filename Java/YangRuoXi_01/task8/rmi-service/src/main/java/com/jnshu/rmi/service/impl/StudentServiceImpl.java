package com.jnshu.rmi.service.impl;

import com.jnshu.rmi.beans.Student;
import com.jnshu.rmi.mapper.StudentMapper;
import com.jnshu.rmi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = "com.jnshu.rmi.*")
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> findAllStu() {
        return studentMapper.selectAllStudent();
    }

    @Override
    public Student findStuById(Long id) {
        return studentMapper.selectStudentById(id);
    }
}
