package com.jnshu.dao;

import com.jnshu.pojo.FirstWork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FirstWorkMapper {

    int deleteByPrimaryKey(long id);

    int insert(FirstWork record);

    int insertSelective(FirstWork record);

    FirstWork selectByPrimaryKey(long id);

    int updateByPrimaryKeySelective(FirstWork record);

    int updateByPrimaryKey(FirstWork record);

    List <FirstWork> selectByDynamic(@Param("name") String name, @Param("status")Integer status);
}