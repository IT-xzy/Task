package org.wyq.task.mapper;

import java.util.List;
import org.wyq.task.pojo.Profession;

public interface ProfessionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Profession record);

    Profession selectByPrimaryKey(Integer id);

    List<Profession> selectAll();

    int updateByPrimaryKey(Profession record);

    List<Profession> selectByDirection(String direction);

    List<String> directionCategoryList();
}