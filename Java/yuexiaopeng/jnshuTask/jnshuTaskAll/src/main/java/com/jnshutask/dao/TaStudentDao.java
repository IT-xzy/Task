package com.jnshutask.dao;

import com.jnshutask.pojo.TaStudent;
import com.jnshutask.pojo.example.TaStudentExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TaStudentDao {
    long countByExample(TaStudentExample example);

    int deleteByExample(TaStudentExample example);

    int insert(TaStudent record);

    int insertSelective(TaStudent record);

    List<TaStudent> selectByExample(TaStudentExample example);

    int updateByExampleSelective(@Param("record") TaStudent record, @Param("example") TaStudentExample example);

    int updateByExample(@Param("record") TaStudent record, @Param("example") TaStudentExample example);
}