package com.jnshu.service.impl;

import com.jnshu.dao.StudentDao;
import com.jnshu.pojo.Page;
import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/1/7 - 22:08
 */

@Service
public class StudentServletImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int total(){
        return studentDao.total();
    }
    @Override
    public int add(Student student){
       return studentDao.add(student);
    }

    @Override
    public int delete(int id){

        return studentDao.delete(id);
    }

    @Override
    public int update(Student student){
        return studentDao.update(student);
    }

    @Override
    public Student get(int id){
        return studentDao.get(id);
    }


    @Override
    public List<Student> findAll(){
        return studentDao.findAll();
    }

    @Override
    public List<Student> list(Page page){
        return studentDao.list(page);
    }

    @Override
    public List<Student> byName(String name){
        return studentDao.byName(name);
    }
}
