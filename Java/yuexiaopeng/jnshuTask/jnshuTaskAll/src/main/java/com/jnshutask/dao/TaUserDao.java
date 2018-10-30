package com.jnshutask.dao;

import com.jnshutask.pojo.TaUser;
import com.jnshutask.pojo.example.TaUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TaUserDao {
    long countByExample(TaUserExample example);

    int deleteByExample(TaUserExample example);

    int insert(TaUser record);

    int insertSelective(TaUser record);

    List<TaUser> selectByExample(TaUserExample example);

    int updateByExampleSelective(@Param("record") TaUser record, @Param("example") TaUserExample example);

    int updateByExample(@Param("record") TaUser record, @Param("example") TaUserExample example);
}