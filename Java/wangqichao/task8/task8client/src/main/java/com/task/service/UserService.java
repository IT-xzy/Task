package com.task.service;

import com.task.models.User;

public interface UserService {
    int justAdd(User user)throws Exception;
    Boolean justUpdate(User user)throws Exception;
    Boolean justDelete(int id)throws Exception;
    User listByName(String username)throws Exception;
    Boolean updateLoginTime(User user);

}
