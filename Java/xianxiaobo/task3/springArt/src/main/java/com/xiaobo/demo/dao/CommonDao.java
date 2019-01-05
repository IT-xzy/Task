package com.xiaobo.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonDao {
    public Integer getTotal(@Param("tableName")String tableName);
}
