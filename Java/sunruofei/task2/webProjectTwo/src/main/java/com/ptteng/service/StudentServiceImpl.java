package com.ptteng.service;

import com.ptteng.dao.StudentDao;
import com.ptteng.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
@Autowired
    StudentDao studentDao;
    @Override
    public int add(Student student) {
        return studentDao.add(student);
    }

    @Override
    public boolean delete(int id) {
        return studentDao.delete(id);
    }

    @Override
    public boolean update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public int findRow() {
        return studentDao.findRow();
    }

    @Override
    public List<Student> findData(int first, int second) {
        return studentDao.findData(first,second);
    }
}
