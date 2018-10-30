package com.service;


import com.model.People;

import java.util.List;

public interface UserService {

    People login(String user, String password);

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

    People selectByTel(long tel, String password);

    People selectByEmail(String email, String password);

    //修改个人信息
    int updatePeople(People people);

    //手机验证码次数验证
    boolean checkTelSum(long tel);

}
