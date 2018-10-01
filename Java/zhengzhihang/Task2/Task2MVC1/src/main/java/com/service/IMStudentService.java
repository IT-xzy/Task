package com.service;

import com.dao.StudentMapper;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IMStudentService implements IFStudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public Student findStudentById(int id) {
        return studentMapper.selectStudentById(id);
    }

    @Override
    public Student findStudentByName(String name) {
        return studentMapper.selectStudentByName(name);
    }

    @Override
    //数据层返回的是一个int值，在这里对int值判断，返回一个布林值。
    public boolean inputStudent(Student student) {
        return studentMapper.insertStudent(student) !=0;
    }

    @Override
    public boolean outputStudentById(int id) {
        return studentMapper.deleteStudentById(id) !=0;
    }

    @Override
    public boolean replayStudent(Student student) {
        return studentMapper.updateStudentById(student) !=0;
    }

    @Override
    public List<Student> findStudent() {
        return studentMapper.selectStudent();
    }
}
