package com.jnshu.task2.service.impl;

import com.jnshu.task2.beans.Student;
import com.jnshu.task2.mapper.StudentMapper;
import com.jnshu.task2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean updateStuTypeById(Integer id,Student student) {
        return studentMapper.updateStuTypeById(student);
    }

    @Override
    public Student selectStuById(Integer id) {
        Student student = studentMapper.selectStuById(id);
        return student;
    }

    @Override
    public List<Student> selectStuAll() {
        List<Student> students = studentMapper.selectStuAll();
        return students;
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

    @Override
    public List<Student> selectStuByPage(Integer start, Integer pageSize) {
        List<Student> list = studentMapper.selectStuByPage(start,pageSize);
        return list;
    }


}
