package com.ptteng.dao;

import com.ptteng.entity.Profession;
import com.ptteng.entity.Temp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Profession record);

    int insertSelective(Profession record);

    Profession selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Profession record);

    int updateByPrimaryKey(Profession record);

    List<Profession> selectByDynamicCondition(Long directionId);

    List<Profession> selectAll();
    List<Temp> selectStudentNumber();
}