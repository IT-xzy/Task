package com.task7.mapper;

import com.task7.pojo.Profession;

import java.util.List;

public interface ProfessionMapper {

    //    查询数据总量
    int selectCount();
    //查询职业页面所有数据
    List<Profession> selectProfession();

    //    查询对应职业方向
    List<Profession> findById(String direction);

    //新增
    int insertProfession(Profession profession);

    //    根据职业方向删除
    boolean deleteByDirection(String direction);


}
