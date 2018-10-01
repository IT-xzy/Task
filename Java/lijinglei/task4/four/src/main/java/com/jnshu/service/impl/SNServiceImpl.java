package com.jnshu.service.impl;

import com.jnshu.dao.StudentNumMapper;
import com.jnshu.model.StudentNum;
import com.jnshu.service.SNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("sNService")
public class SNServiceImpl implements SNService {
    @Autowired
    private StudentNumMapper SNDao;

    public StudentNumMapper getESMapper() {
        return SNDao;
    }

    public void setESMapper(StudentNumMapper SNDao) {
        this.SNDao = SNDao;
    }

    @Override
    public StudentNum findById(Integer id) {
        return SNDao.selectByPrimaryKey(id);
    }

    @Override
    public List<StudentNum> listAll() {
        return SNDao.listAll();
    }

}