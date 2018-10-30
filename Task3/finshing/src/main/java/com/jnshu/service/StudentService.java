package com.jnshu.service;

import com.jnshu.entity.Student;
import com.jnshu.mapper.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

   /* @Autowired
    private StudentDao studentDao;

    public long findTotal() {
        return studentDao.findTotal();
    }

    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public Student findOneById(long id) {
        return studentDao.findOneById(id);
    }

    public boolean updateSelective(Student student) {
        return studentDao.updateSelective(student);
    }

    public boolean deleteById(long id) {
        return studentDao.deleteById(id);
    }

    public boolean insert(Student student) {
        return studentDao.insert(student);
    }*/
}
