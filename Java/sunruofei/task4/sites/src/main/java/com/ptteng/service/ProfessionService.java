package com.ptteng.service;

import com.ptteng.model.Profession;
import com.ptteng.model.Temp;

import java.util.List;

public interface ProfessionService {
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
