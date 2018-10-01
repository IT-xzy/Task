package com.task6.service;

import com.task6.pojo.Profession;

import java.util.List;

public interface ProfessionService {
    //查询职业页面所有数据
    List<Profession> selectProfession();

    //    根据职业方向删除
    boolean deleteByDirection(String direction);
}
