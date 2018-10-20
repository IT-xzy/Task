package com.task5.service;

import com.task5.pojo.User;

public interface UserService {
    String login(User user)throws Exception;
    String register(User user)throws Exception;
    User findUserByPhoneNumber(String phoneNumber)throws Exception;
    User findUserByEmail(String email)throws Exception;
    Integer updateUser(User user) throws Exception;
}
