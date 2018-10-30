package com.ptteng.service;


import com.ptteng.Student;
import com.ptteng.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

//    返回主键id看一下。
    public long insertStudent(Student student){
        return studentDao.insertStudent(student);
    }

    public List<Student> findAll(){
        return studentDao.findAll();
    }

    public boolean updateStudent(Student student){
        return studentDao.updateStudent(student);
    }

    public boolean deleteStudent(long id){
        return studentDao.deleteStudent(id);
    }

    public Student fingById(long id){
        return studentDao.findById(id);
    }

    public long count(){
        return studentDao.count();
    }

    public List<Student> findPage(long pageStart){
        return studentDao.findPage(pageStart);
    }
}
