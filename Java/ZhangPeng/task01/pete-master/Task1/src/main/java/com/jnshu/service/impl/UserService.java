package com.jnshu.service.impl;

import com.jnshu.model.User;

import java.util.List;

public interface UserService{
    List<User> findUserAll() throws Exception;
  List<User> findUserByCondition(String s) throws Exception;
   User  findUserById(int i) throws Exception;

    //插入
    int insertUser(User user) throws Exception;
    //删除
    boolean deleteUser(long l) throws  Exception;
    //更新
    boolean updateUser(User user) throws Exception;
    void forList(List<User>user);

}


