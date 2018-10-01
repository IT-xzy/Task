package com.jnshu.czm.service;

import com.jnshu.czm.model.Student;
import com.jnshu.czm.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("studentService")
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentDao studentDao;

    @Override
    public Student findById(int studentId) {
        Student student=studentDao.findById(studentId);
        return student;
    }

    @Override
    public List<Student> findAll() {
        List<Student> student=studentDao.findAll();
        return student;
    }

    @Override
    public int selectCount() {
        return studentDao.selectCount();
    }

    @Override
    public int selectAt() {
        return studentDao.selectAt();
    }

}
