package com.jnshu.service;

import com.jnshu.entity.Student;
import com.jnshu.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public  long findTotal(){
        return studentMapper.findTotal();
    }
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    public Student findOneById(long id) {
        return studentMapper.findOneById(id);
    }

    public boolean updateSelective(Student student) {
        return studentMapper.updateSelective(student);
    }
    public boolean deleteById(long id) {
        return studentMapper.deleteById(id);
    }
    public boolean insert(Student student) {
        return studentMapper.insert(student);
    }
}
