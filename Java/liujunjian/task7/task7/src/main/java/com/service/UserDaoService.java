package com.service;

import com.exception.MyException;
import com.pojo.User;

import java.security.NoSuchAlgorithmException;

public interface UserDaoService {
    boolean login(User user) throws MyException, NoSuchAlgorithmException;

    boolean register(User user) throws MyException, NoSuchAlgorithmException;

    boolean update(User user) throws MyException;

    User getUser(String username) throws MyException;
}
