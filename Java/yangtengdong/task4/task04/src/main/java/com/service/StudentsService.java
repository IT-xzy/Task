package com.service;

import com.entity.Students;

import java.util.List;

public interface StudentsService {
    Students findById(Integer id);
    List<Students> listGood();
    Integer count(Integer status);
    Integer countAll();
}
