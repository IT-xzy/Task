package com.task.service.impl;

import com.task.dao.StudentDao;
import com.task.entity.Student;


import com.task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> findById(int id) {

        List<Student> students = studentDao.findById(id);
        if(students != null){

            return students;
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> students = studentDao.findByName(name);
        if(students != null){

            return students;
        }
        return null;
    }

    @Override
    public List<Student> findByNumber(int number) {

        List<Student> students = studentDao.findByNumber(number);
        if(students != null){

            return students;
        }
        return null;
    }

    public void delete(Student student){
        studentDao.delete(student.getId());
    }

}
