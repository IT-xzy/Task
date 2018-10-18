package com.task5.service.impl;

import com.task5.mapper.EliteStudentsDao;
import com.task5.pojo.EliteStudents;
import com.task5.service.EliteStudentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("EliteStudentsServiceImpl")
public class EliteStudentsServiceImpl implements EliteStudentsService {
    @Resource
    private EliteStudentsDao studentsDao;

    @Override
    public List<EliteStudents> getAllStudents() throws Exception {
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
