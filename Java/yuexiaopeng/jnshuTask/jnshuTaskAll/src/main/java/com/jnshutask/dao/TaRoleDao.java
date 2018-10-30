package com.jnshutask.dao;

import com.jnshutask.pojo.TaRole;
import com.jnshutask.pojo.example.TaRoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TaRoleDao {
    long countByExample(TaRoleExample example);

    int deleteByExample(TaRoleExample example);

    int insert(TaRole record);

    int insertSelective(TaRole record);

    List<TaRole> selectByExample(TaRoleExample example);

    int updateByExampleSelective(@Param("record") TaRole record, @Param("example") TaRoleExample example);

    int updateByExample(@Param("record") TaRole record, @Param("example") TaRoleExample example);
}