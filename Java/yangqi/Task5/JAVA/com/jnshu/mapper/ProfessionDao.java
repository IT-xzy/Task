package com.jnshu.mapper;

import com.jnshu.entity.Profession;

import java.util.List;

public interface ProfessionDao {

    //获取profession全部信息
    List<Profession> findAlls();
    int findName();
    Profession addlist(Profession profession);
}
