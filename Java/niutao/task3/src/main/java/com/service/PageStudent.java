package com.service;

import com.mapper.StudentMapper;
import com.pojo.Page;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageStudent {
    @Autowired
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public int getTotal(){
        return this.studentMapper.total();
    }

    public List<Student> doSomeBusinessStuff(Page page){
        return this.studentMapper.list(page);
    }
}
