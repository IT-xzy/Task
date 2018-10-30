package com.jnshutask.dao;

import com.jnshutask.pojo.TaRoleMenu;
import com.jnshutask.pojo.example.TaRoleMenuExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TaRoleMenuDao {
    long countByExample(TaRoleMenuExample example);

    int deleteByExample(TaRoleMenuExample example);

    int insert(TaRoleMenu record);

    int insertSelective(TaRoleMenu record);

    List<TaRoleMenu> selectByExample(TaRoleMenuExample example);

    int updateByExampleSelective(@Param("record") TaRoleMenu record, @Param("example") TaRoleMenuExample example);

    int updateByExample(@Param("record") TaRoleMenu record, @Param("example") TaRoleMenuExample example);
}