package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService{
    @Autowired
    CommonDao commonDao;
    @Override
    public Integer getTotal(String tableName){
        return commonDao.getTotal(tableName);
    }
}
