package com.how2java.service.impl;

import com.how2java.mapper.StudentMapper;
import com.how2java.pojo.Student;
import com.how2java.service.StudentService;
import com.how2java.util.StudentPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    public List<Student> list(){
        return studentMapper.list();
    }

    public List<Student> list(StudentPage studentpage){
        return studentMapper.list(studentpage);
    }

    public int total(){
        return studentMapper.total();
    }

    public void add(Student student){
        studentMapper.add(student);
    }
    public void update(Student student){
        studentMapper.update(student);
    }

    public void delete(Student student){
        studentMapper.delete(student.getId());
    }

    public Student get(int id){
        return studentMapper.get(id);
    }

}
