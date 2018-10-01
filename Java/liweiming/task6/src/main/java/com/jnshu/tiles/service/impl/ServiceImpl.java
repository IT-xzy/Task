package com.jnshu.tiles.service.impl;


import com.jnshu.tiles.entity.Profession;
import com.jnshu.tiles.entity.Student;
import com.jnshu.tiles.dao.StudentDAO;
import com.jnshu.tiles.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceImpl implements StuService {

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
