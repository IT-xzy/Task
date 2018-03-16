package com.jnshu.service.Impl;
import com.jnshu.dao.StudentMapper;
import com.jnshu.model.Student;
import com.jnshu.service.IStudentService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public int insertStudent(Student student) throws IOException {
        return studentMapper.insert(student);
    }

    @Override
    public List<Student> getAllStudent() throws IOException {
        return studentMapper.getAllStudent();
    }

    @Override
    public int deleteStudent(int id) throws IOException {
        return studentMapper.deleteById(id);
    }

    @Override
    public Student getStudentById(int id) throws IOException {
        return studentMapper.selectById(id);
    }

    @Override
    public int updateStudent(Student student) throws IOException {
        return studentMapper.updateById(student);
    }

    @Override
    public int countStudentById(int id) throws IOException {
        return studentMapper.countStudentById(id);
    }
}