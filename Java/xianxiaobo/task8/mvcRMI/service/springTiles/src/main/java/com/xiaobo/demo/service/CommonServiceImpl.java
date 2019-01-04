package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service("CommonServiceImpl")
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
    @Override
    public Integer test(){
        return 1;
    }
    @Override
    public Boolean isToday(Long timestamp){
        Date date1 = new Date(timestamp);
        Date date2 = new Date();
        System.out.println(date1);
        System.out.println(date2);
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar2.setTime(date2);
        return calendar1.get(0) == calendar2.get(0) && calendar1.get(1) == calendar2.get(1) && calendar1.get(6) == calendar2.get(6);
    }
    @Override
    public String testService(){
        return "来自于service1的服务";
    }
}
