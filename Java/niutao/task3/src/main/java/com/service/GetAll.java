package com.service;

import com.mapper.StudentMapper;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAll {
    @Autowired
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper){
        this.studentMapper = studentMapper;
    }

    public List<Student> doSomeBusinessStuff() throws Exception {
        return this.studentMapper.list();
    }
}
