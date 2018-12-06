package com.lyh.service.impl;

import com.lyh.entity.Student;
import com.lyh.dao.StudentDao;
import com.lyh.page.Page;
import com.lyh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//实现类
public class StudentServiceImpl implements StudentService {
    //注入dao层
    @Autowired
    StudentDao studentDao;

    @Override
    public int total() {
        return studentDao.total();
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public int deleteStudent(Long id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public Student getStudent(Long id) {
        return studentDao.getStudent(id);
    }

    @Override
    public List<Student> listStudent() {
        return studentDao.listStudent();
    }

    @Override
    public List<Student> listPageStudent(Page page) {
        return studentDao.listPageStudent(page);
    }

    @Override
    public List<Student> byName(String name) {
        return studentDao.byName(name);
    }
}
