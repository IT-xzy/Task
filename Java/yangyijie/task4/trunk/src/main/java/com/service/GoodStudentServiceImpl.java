package com.service;

import com.bean.GoodStudent;
import com.dao.GoodStudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arike
 * Create_at 2017/12/28 16:07
 */
@Service
public class GoodStudentServiceImpl implements IgoodStudentService {
    @Autowired
    GoodStudentDao goodStudentDao;
    @Override
    public List<GoodStudent> selectAll() {
        return goodStudentDao.selectAll();
    }
    
    @Override
    public Integer count() {
        return goodStudentDao.count();
    }
    
    @Override
    public Integer countGood() {
        return goodStudentDao.countGood();
    }
}
