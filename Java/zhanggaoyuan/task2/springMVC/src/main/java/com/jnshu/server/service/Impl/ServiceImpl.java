package com.jnshu.server.service.Impl;

import com.jnshu.server.dao.StudentsDao;
import com.jnshu.server.po.Students;
import com.jnshu.server.service.BeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("beanService")
//@Service
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
    public boolean updateOneStudents(Students students) {
        return studentsDao.updateOneStudents (students);
    }

    @Override
    public boolean update(Students students) {
        return studentsDao.update (students);
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

    @Override
    public List selectAll() {
        return studentsDao.selectAll ();
    }

//    @Override
//    public List<Students> selectInfoByMap(Map<String, Object> map) {
//        return studentsDao.selectInfoByMap (map);
//    }
}