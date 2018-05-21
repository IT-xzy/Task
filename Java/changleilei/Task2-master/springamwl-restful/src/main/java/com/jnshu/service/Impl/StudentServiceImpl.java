package com.jnshu.service.Impl;

import com.jnshu.dao.StudentMapper;
import com.jnshu.model.Student;
import com.jnshu.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    @Resource
    private StudentMapper studentMapper;

    public int insertStudent(Student student) throws IOException {
        return studentMapper.insert(student);
    }

    public List<Student> getAllStudent() throws IOException {
        return studentMapper.getAllStudent();
    }

    public int deleteStudent(int id) throws IOException {
        return studentMapper.deleteById(id);
    }

    @Override
    public Student getStudentById(int id) throws IOException {
        return studentMapper.selectById(id);
    }

    public int countAll() throws IOException {
        return studentMapper.countAll();
    }

    public int updateStudent(Student student) throws IOException {
        return studentMapper.updateById(student);
    }

    public int countStudentById(int id) throws IOException {
        return studentMapper.countStudentById(id);
    }
}