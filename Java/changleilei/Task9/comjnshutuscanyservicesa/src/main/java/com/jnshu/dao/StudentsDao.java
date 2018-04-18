package com.jnshu.dao;
import com.jnshu.model.Students;

import java.util.List;

public interface StudentsDao {
    int deleteById(Long id);
    int insert(Students record);
    int insertSelective(Students record);
    Students selectById(Long id);
    int updateByIdSelective(Students record);
    int updateById(Students record);
    List<Students> selectAll();
    int updateByName(Students students);
}