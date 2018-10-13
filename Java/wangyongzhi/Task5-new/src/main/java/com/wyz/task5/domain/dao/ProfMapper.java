package com.wyz.task5.domain.dao;


import com.wyz.task5.domain.entity.Prof;


public interface ProfMapper {

    //根据名称查询职业信息
    public Prof getByProf(String profession);
}
