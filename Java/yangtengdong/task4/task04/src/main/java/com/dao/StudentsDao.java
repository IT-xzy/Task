package com.dao;

import com.entity.Students;

import java.util.List;

public interface StudentsDao {
    Students findById(Integer id);
    List<Students> listGood();
    Integer count(Integer status);
    Integer countAll();
}
