package com.jnshu.dao;

import com.jnshu.pojo.FirstWork;
import com.jnshu.pojo.SecondWork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FirstWorkMapper {

    int deleteByPrimaryKey(long firstId);

    int insert(FirstWork record);

    int insertSelective(FirstWork record);

    FirstWork selectByPrimaryKey(long firstId);

    int updateByPrimaryKeySelective(FirstWork record);

    int updateByPrimaryKey(FirstWork record);

    List <FirstWork> selectByDynamic(@Param("firstName") String firstName, @Param("status")Integer status);


}