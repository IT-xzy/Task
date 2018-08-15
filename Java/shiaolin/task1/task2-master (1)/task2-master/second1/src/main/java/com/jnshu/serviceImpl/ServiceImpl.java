package com.jnshu.serviceImpl;

import com.jnshu.pojo.Student;
import com.jnshu.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jnshu.service.StudentService;

import java.util.List;

@Service
public class ServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public Student queryUser(int i) {
        return studentDao.getStudentById(i);
    }

    @Override
    public boolean addUser(Student user) {
        return studentDao.addStudent(user);
    }
    @Override
    public Student queryName(String name){
        return studentDao.getStudentByName(name);
        }

    @Override
    public boolean deleteUser(int i){
        return studentDao.deleteStudent(i);
    }
    @Override
    public boolean updataUser(Student user){
        return studentDao.updataStudent(user);
    }
    @Override
    public List<Student> allStudent(){
        return studentDao.allStudent();
    }
}
