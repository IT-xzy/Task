package com.jns.service;

import com.jns.pojo.Users;

import java.util.List;

public interface UsersService {
    void add(Users users);
    void update(Users users);
    List<Users> list();
    Users findByName(String phone);
    Users checkLogin(String phone ,String password);
}
