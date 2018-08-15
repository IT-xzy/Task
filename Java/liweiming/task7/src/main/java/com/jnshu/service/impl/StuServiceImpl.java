package com.jnshu.service.impl;


import com.jnshu.entity.Profession;
import com.jnshu.entity.Student;
import com.jnshu.dao.StudentDAO;
import com.jnshu.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    StudentDAO studentDAO;


    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public List<Profession> findAlls() {
        return studentDAO.findAlls();
    }

    @Override
    public Integer stuCount() {
        return studentDAO.stuCount();
    }

    @Override
    public Integer workCount() {
        return studentDAO.workCount();
    }


}
