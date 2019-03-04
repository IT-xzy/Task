package com.jnshu.service.impl;

import com.jnshu.beans.Student;
import com.jnshu.mapper.StudentMapper;
import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void addStu(Student student) {
        studentMapper.addStu(student);
    }

    @Override
    public boolean delStuById(Integer id) {

        return studentMapper.delStuById(id);

    }

    @Override
    public boolean updateStuTypeById(Integer id,String type, Long updateAt) {
        return studentMapper.updateStuTypeById(id,type,updateAt);

    }

    @Override
    public Student selectStuById(Integer id) {
        Student student = studentMapper.selectStuById(id);
        return student;
    }

    @Override
    public Student selectStuAll() {
        Student student = studentMapper.selectStuAll();
        return student;
    }

    @Override
    public Student selectStuByName(String name) {
        Student student = studentMapper.selectStuByName(name);
        return student;
    }

    @Override
    public Student selectStuByOnlineNumber(Integer onlineNumber) {
        Student student = studentMapper.selectStuByOnlineNumber(onlineNumber);
        return student;
    }




}
