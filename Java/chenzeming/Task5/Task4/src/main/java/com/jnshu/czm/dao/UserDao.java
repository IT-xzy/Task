package com.jnshu.czm.dao;

import com.jnshu.czm.model.User;

import java.util.List;


public interface UserDao {

    User findUserById(Integer id);  //通过id查询

    List<User> findAll();//查询全部用户

    int selectCount();//查询用户记录总数

}