package com.ev.service;

import com.ev.entity.User;

public interface UserService {

    User findUser(String str) throws Exception;

    Long signUp(User user) throws Exception;

    boolean login(String account, String password) throws Exception;

}
