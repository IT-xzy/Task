package com.xiaobo.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface CommonService {
    public Integer getTotal(String tableName);
    public <T> Boolean isDataExist(String tableName, String column, T value);
    public <T> Integer countData(String tableName, String column, T value);
}
