package com.task5.service;

import com.task5.pojo.User;

public interface UserService {
    String login(User user)throws Exception;
    String register(User user)throws Exception;
}
