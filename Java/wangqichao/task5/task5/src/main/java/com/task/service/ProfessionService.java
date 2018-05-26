package com.task.service;

import com.task.models.Profession;

public interface ProfessionService {
    //增
    int justAdd(Profession profession)throws Exception;
    //删
    Boolean justDelete(int id)throws Exception;
    //更新
    Boolean justUpdate(Profession profession)throws Exception;
    //通过name查询
    Profession justListByName(String name) throws Exception;
}
