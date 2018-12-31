package com.mutesaid.bootdemo.service.impl;

import com.mutesaid.bootdemo.mapper.StudentMapper;
import com.mutesaid.bootdemo.model.Student;
import com.mutesaid.bootdemo.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<Student> listStudentByQuery(String type, Long startAt, Long endAt) {
        return studentMapper.listStudentByQuery(type, startAt, endAt);
    }

    @Override
    public Student findById(Long id) {
        return studentMapper.findById(id);
    }

    @Override
    public Long saveStudent(Student stu) {
        stu.setUpdateAt(System.currentTimeMillis());
        stu.setCreateAt(System.currentTimeMillis());
        studentMapper.saveStudent(stu);
        return stu.getId();
    }

    @Override
    public Long deleteStudent(Long id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public Long updateStudent(Student stu) {
        stu.setUpdateAt(System.currentTimeMillis());
        return studentMapper.updateStudent(stu);
    }
}
