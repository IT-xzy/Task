package com.jnshutask.dao;

import com.jnshutask.pojo.TaMenu;
import com.jnshutask.pojo.example.TaMenuExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TaMenuDao {
    long countByExample(TaMenuExample example);

    int deleteByExample(TaMenuExample example);

    int insert(TaMenu record);

    int insertSelective(TaMenu record);

    List<TaMenu> selectByExample(TaMenuExample example);

    int updateByExampleSelective(@Param("record") TaMenu record, @Param("example") TaMenuExample example);

    int updateByExample(@Param("record") TaMenu record, @Param("example") TaMenuExample example);

    List<TaMenu> findUserMenus(String userName);

    List<TaMenu> findUserPermissions(String userName);


}