package com.ptteng.service;

import com.ptteng.Student;
import com.ptteng.dao.StudentDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public long insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    public boolean deleteStudent(long id) {
        return studentDao.deleteStudent(id);
    }

    public Student findById(long id) {
        return studentDao.findById(id);
    }
}
