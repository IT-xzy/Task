package com.jnshu.service.impl;

import com.jnshu.dao.StudentDao;
import com.jnshu.model.Student;
import com.jnshu.service.StudentService;
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
    public List<Student> selectProductsPage(int first, int second) {
        return studentDao.selectProductsPage(first,second);
    }

    @Override
    public int selectRow() {
        return studentDao.selectRow();
    }
}
