package com.ptteng.service.Impl;

import com.ptteng.dao.OccupationDao;
import com.ptteng.dao.StudentsDao;
import com.ptteng.model.Occupation;
import com.ptteng.model.Student;
import com.ptteng.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("occupationServiceImpl")
public class OccupationServiceImpl implements OccupationService {
    @Autowired
    OccupationDao occupationDao;
    @Override
    public List<Occupation> get() throws Exception {
        return occupationDao.getAll();
    }
    @Autowired
    StudentsDao studentsDao;
    public List<Student> get1() throws  Exception{
        return studentsDao.getall();
    }
}
