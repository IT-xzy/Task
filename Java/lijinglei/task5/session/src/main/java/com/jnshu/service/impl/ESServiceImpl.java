package com.jnshu.service.impl;

import com.jnshu.dao.ExcellentStudentMapper;
import com.jnshu.model.ExcellentStudent;
import com.jnshu.service.ESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class ESServiceImpl implements ESService {
    @Autowired
    private ExcellentStudentMapper ESDao;

    public ExcellentStudentMapper getESMapper() {
        return ESDao;
    }

    public void setESMapper(ExcellentStudentMapper ESDao) {
        this.ESDao = ESDao;
    }

    @Override
    public ExcellentStudent findById(Integer id) {
        return ESDao.selectByPrimaryKey(id);
    }

    @Override
    public List<ExcellentStudent> listAll() {
        return ESDao.listAll();
    }
}