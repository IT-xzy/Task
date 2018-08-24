package com.jnshu.czm.dao;

import com.jnshu.czm.model.User;
import com.jnshu.czm.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao {

     Users findUserById(int userId);

     void insertUser(Users users);

     Users findUserByName(String username);

    boolean updateUser(Users users);//更改用户
}
