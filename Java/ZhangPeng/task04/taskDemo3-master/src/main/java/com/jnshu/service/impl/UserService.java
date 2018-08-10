package com.jnshu.service.impl;

import com.jnshu.model.User;
import com.jnshu.model.UserCustom;
import com.jnshu.model.UserQv;

import java.util.List;

public interface UserService{
    List<User> findUserAll() throws Exception;
  List<User> findUserByCondition(UserQv userQv) throws Exception;
   UserCustom findUserById(int i) throws Exception;

    //插入
    int insertUser(User user) throws Exception;
    //删除
    boolean deleteUser(long l) throws  Exception;
    //更新
    boolean updateUser(User user) throws Exception;
    void forList(List<User> user);

    boolean test();
}


