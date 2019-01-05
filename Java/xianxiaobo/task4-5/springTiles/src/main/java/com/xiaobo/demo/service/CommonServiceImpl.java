package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    CommonMapper commonMapper;
    @Override
    public Integer getTotal(String tableName){
        return commonMapper.getTotal(tableName);
    }
    @Override
    public <T> Boolean isDataExist(String tableName,String column,T value){
        String newValue = "'"+value + "'";
        return commonMapper.isDataExist(tableName,column,newValue) == 1;
    }
    @Override
    public <T> Integer countData(String tableName,String column,T value){
        String newValue = "'"+value + "'";
        return commonMapper.isDataExist(tableName,column,newValue);
    }
}
