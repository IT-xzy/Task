package jnshu.dao;

import jnshu.model.Profession;

import java.util.List;

public interface ProfessionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Profession record);

    int insertSelective(Profession record);

    Profession selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Profession record);

    int updateByPrimaryKey(Profession record);

    //    查询职业信息
    List selectProfession();
}