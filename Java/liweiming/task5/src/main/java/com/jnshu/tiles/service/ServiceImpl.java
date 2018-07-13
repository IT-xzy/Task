package com.jnshu.tiles.service;


import com.jnshu.tiles.entity.Profession;
import com.jnshu.tiles.entity.StuStatistics;
import com.jnshu.tiles.entity.Student;
import com.jnshu.tiles.mapper.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceImpl implements StuService{

    @Autowired
    StudentDao studentDao;


    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public List<Profession> findAlls() {
        return studentDao.findAlls();
    }

    @Override
    public Integer stuCount() {
        return studentDao.stuCount();
    }

    @Override
    public Integer workCount() {
        return studentDao.workCount();
    }


}
