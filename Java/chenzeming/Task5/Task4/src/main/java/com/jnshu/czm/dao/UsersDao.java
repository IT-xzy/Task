package com.jnshu.czm.dao;

import com.jnshu.czm.model.Users;

public interface UsersDao {

     Users findUserById(int userId);

     void insertUser(Users users);

     Users findUserByName(String username);
}
