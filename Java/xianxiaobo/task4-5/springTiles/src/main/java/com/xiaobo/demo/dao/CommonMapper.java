package com.xiaobo.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonMapper {
    public Integer getTotal(@Param("tableName") String tableName);
    public Integer isDataExist(@Param("tableName") String tableName, @Param("column") String column, @Param("value") String value);
}
