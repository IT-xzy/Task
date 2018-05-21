package com.service;

import com.mapper.StudentMapper;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetStudent {

    @Autowired
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper){
        this.studentMapper = studentMapper;
    }

    public Student doSomeBusinessStuff(int id) throws Exception {
        return this.studentMapper.findStudentById(id);
    }

}
