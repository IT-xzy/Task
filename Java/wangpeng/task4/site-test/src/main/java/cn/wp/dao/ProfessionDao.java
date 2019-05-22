package cn.wp.dao;

import cn.wp.model.Profession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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