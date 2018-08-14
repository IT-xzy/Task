package com.jnshu.service.impl;


import com.jnshu.entity.Student;

import com.jnshu.mapper.StudentDao;

import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;


    @Override
    public List<Student> findAll(){
        return studentDao.findAll();
    }

}
