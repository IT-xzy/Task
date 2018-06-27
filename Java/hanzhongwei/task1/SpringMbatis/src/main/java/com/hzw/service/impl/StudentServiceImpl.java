package com.hzw.service.impl;

import com.hzw.mapper.StudentMapper;
import com.hzw.pojo.Student;
import com.hzw.service.StudentService;
import com.hzw.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> getAll() {
        return studentMapper.getAll();
    }

    @Override
    public void addStu(Student student) {
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        studentMapper.addStu(student);
    }

    @Override
    public void deleteStu(long s_id) {
        System.out.println("========Impl删除id================"+s_id);
        studentMapper.deleteStu(s_id);
    }

    @Override
    public void updateStu(Student student) {
        student.setUpdate_at(System.currentTimeMillis());
        studentMapper.updateStu(student);
    }

    @Override
    public Student getId(long s_id) {
        return studentMapper.getId(s_id);
    }

    /*@Override
    public int total() {
        return studentMapper.total();
    }

    @Override
    public List<Student> getAll(Page page) {
        return studentMapper.getAll(page);
    }*/
}
