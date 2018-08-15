package com.fgh.task2.dao;

import com.fgh.task2.model.Pro;

import java.util.List;

public interface ProDao {
    Integer addPro(Pro pro);
    Integer deletePro(int id);
    Integer updatePro(Pro pro);
    Pro queryPro(int id);
    List<Pro> getListPro();

}
