package com.mutesaid.impl;

import com.mutesaid.mapper.StudentMapper;
import com.mutesaid.model.Student;
import com.mutesaid.service.StudentService;
import org.oasisopen.sca.annotation.Remotable;

import javax.annotation.Resource;
import java.util.List;


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
