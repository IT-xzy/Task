package com.jnshu.server.service.Impl;

import com.jnshu.server.dao.StudentsDao;
import com.jnshu.server.po.Students;
import com.jnshu.server.service.BeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements BeanService{
    @Autowired
    StudentsDao studentsDao;
    @Override
    public long insertStudents(Students students) {
        return studentsDao.insertStudents (students);
    }

    @Override
    public boolean deleteStudents(long id) {
        return studentsDao.deleteStudents (id);
    }

    @Override
    public boolean updateStudents(Students students) {
        return studentsDao.updateStudents (students);
    }

    @Override
    public boolean updateOne(Students students) {
        return studentsDao.updateOne (students);
    }

    @Override
    public Students selectStudents(long id) {
        return studentsDao.selectStudents (id);
    }

    @Override
    public List selectIf(Students students) {
        return studentsDao.selectIf (students);
    }

    @Override
    public long batchInsert(Students[] students) {
        return studentsDao.insertBatch (students);
    }
}