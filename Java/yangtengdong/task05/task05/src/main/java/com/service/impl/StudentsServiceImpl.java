package com.service.impl;

import com.dao.StudentsDao;
import com.entity.Students;
import com.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {
    @Autowired
    private StudentsDao studentsDao;

    @Override
    public Students findById(Integer id) {
        return studentsDao.findById(id);
    }

    @Override
    public List<Students> listGood() {
        return studentsDao.listGood();
    }

    @Override
    public Integer count(Integer status) {
        return studentsDao.count(status);
    }

    @Override
    public Integer countAll() {
        return studentsDao.countAll();
    }
}
