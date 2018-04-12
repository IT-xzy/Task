package com.fml.service.impl;

import com.fml.mapper.StudentMapper;
import com.fml.pojo.Student;
import com.fml.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public boolean add(Student student) {
        return studentMapper.add(student);
    }

    @Override
    public boolean deleteById(int id) {
        return studentMapper.deleteById(id);
    }

    @Override
    public boolean deleteAll() {
        return studentMapper.deleteAll();
    }

    @Override
    public boolean update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public Student getById(int id) {
        return studentMapper.getById(id);
    }

    @Override
    public List<Student> getByStatus(int status) {
        return studentMapper.getByStatus(status);
    }

    @Override
    public int getTotalCount() {
        return studentMapper.getTotalCount();
    }

    @Override
    public int getWorkCount() {
        return studentMapper.getWorkCount();
    }

    @Override
    public List<Integer> getStudyCountByLesson() {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i <= 12; i++){
            integerList.add(studentMapper.getStudyCountByLesson(i));
        }
        return integerList;
    }

    @Override
    public Student getStuByEmail(String email) {
        return studentMapper.getStuByEmail(email);
    }
}
