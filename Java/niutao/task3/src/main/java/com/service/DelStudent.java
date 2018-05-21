package com.service;

import com.mapper.StudentMapper;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DelStudent {
    @Autowired
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public void doSomeBusinessStuff(int id) throws Exception {
        this.studentMapper.deleteStudent(id);
    }
}