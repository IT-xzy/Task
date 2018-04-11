package com.jnshu.dao;
import com.jnshu.model.Students;

import java.util.List;

public interface StudentsDao {
    int deleteById(Integer id);
    int insert(Students record);
    int insertSelective(Students record);
    Students selectById(Integer id);
    int updateByIdSelective(Students record);
    int updateById(Students record);
    List<Students> selectAll();
    List<Students> getByNameAndGender(Students students);
}