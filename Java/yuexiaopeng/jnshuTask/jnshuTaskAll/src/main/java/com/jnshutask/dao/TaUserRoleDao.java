package com.jnshutask.dao;

import com.jnshutask.pojo.TaUserRole;
import com.jnshutask.pojo.example.TaUserRoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TaUserRoleDao {
    long countByExample(TaUserRoleExample example);

    int deleteByExample(TaUserRoleExample example);

    int insert(TaUserRole record);

    int insertSelective(TaUserRole record);

    List<TaUserRole> selectByExample(TaUserRoleExample example);

    int updateByExampleSelective(@Param("record") TaUserRole record, @Param("example") TaUserRoleExample example);

    int updateByExample(@Param("record") TaUserRole record, @Param("example") TaUserRoleExample example);
}