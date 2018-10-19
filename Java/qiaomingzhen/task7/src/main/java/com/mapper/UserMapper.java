package com.mapper;/*
 * @ClassName:UserMapper
 * @Description:TODO
 * @Author qiao
 * @Date 2018/7/24 20:57
 **/


import com.model.People;

import java.util.List;

public interface UserMapper {
    //    添加学员
    long addUser(People people);

    //添加学员就业情况
    int selectAll();

    //    在学人数
    void job(People people);

    //    就业人数
    int findJob();

    People selectPeople(People people);

    //    学员展示list
    List<People> listJob();

    People selectByName(String name);
    People selectById(long id);
    People selectByTel(long tel);
    People selectByEmail(String email);

    //修改个人信息
    int updatePeople(People people);
}
