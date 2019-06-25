package cn.wp.dao;

import cn.wp.model.Profession;

import java.util.List;


public interface ProfessionDao {
    int deleteByPrimaryKey(Long id);

    int insert(Profession record);

    int insertSelective(Profession record);

    Profession selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Profession record);

    int updateByPrimaryKey(Profession record);

    List<Profession> selectByDynamicCondition(Long count);

    List<Profession> selectAll();

}