package com.jnshutask.dao;

import com.jnshutask.pojo.TaLogin;
import com.jnshutask.pojo.example.TaLoginExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TaLoginDao {
    long countByExample(TaLoginExample example);

    int deleteByExample(TaLoginExample example);

    int insert(TaLogin record);

    int insertSelective(TaLogin record);

    List<TaLogin> selectByExample(TaLoginExample example);

    int updateByExampleSelective(@Param("record") TaLogin record, @Param("example") TaLoginExample example);

    int updateByExample(@Param("record") TaLogin record, @Param("example") TaLoginExample example);
}