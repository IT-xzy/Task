package com.dao;

import com.exception.MyException;
import com.pojo.User;

public interface UserDao {
    User findUserByName(String username) throws MyException;

    Boolean insertUser(User user) throws MyException;

    Boolean updateUser(User user) throws MyException;
}
