package com.jnshu.service.impl;

import com.jnshu.MyBatis.StudentMapper;
import com.jnshu.model.Student;
import com.jnshu.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("StudentService")
public class StudentServiceiMmpl implements StudentService {
    @Resource
    private StudentMapper userDao;

    @Override
    public long addStudent(Student student) {
        return userDao.addStudent(student);
    }

    @Override
    public int deleteStudent(long id) {
        return userDao.deleteStudent(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        return userDao.updateStudent(student);
    }

    @Override
    public Student findById(long id) {
        return userDao.findById(id);
    }

    public List<Student> findAll() {

        return userDao.findAll();


    }

    @Override
    public List<Student> findUsersByPage(@Param("start") int start, @Param("perPageUsers") int perPageUsers) throws Exception {

        List<Student> list =userDao.findUsersByPage(start, perPageUsers);
        return list;

    }

    @Override
    public List<Student> findUsers() throws Exception {
        List<Student> list = userDao.findUsers();
        return list;
    }
}
