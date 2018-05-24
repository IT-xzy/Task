package com.task.dao;

import com.task.models.Profession;

public interface ProfessionDao {
    //增
    Boolean addPro(Profession profession);
    //删
    Boolean deletePro(int id);
    //查
    Profession getProByName(String name);
    //改
    Boolean updatePro(Profession profession);


}
