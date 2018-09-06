package com.tiles.service.impl;

import com.tiles.mapper.StudentsDao;
import com.tiles.pojo.Students;
import com.tiles.service.StudentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService{
    @Resource
    private StudentsDao studentsDao;

    @Override
    public List<Students> getAllStudents() throws Exception {
        return studentsDao.getAllStudents();
    }

    @Override
    public int getStudyNumber() throws Exception {
        return studentsDao.getStudyNumber();
    }

    @Override
    public int getWorkNumber() throws Exception {
        return studentsDao.getWorkNumber();
    }
}
