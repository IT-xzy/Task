package com.ptteng.service;

import com.ptteng.entity.UserStudent;

import java.util.List;
import java.util.concurrent.TimeoutException;

public  interface UserServiceStudent {
    public  UserStudent selectUser(int paramInt);

    public  void insertUser(UserStudent paramUser);

    public  boolean updateUser(UserStudent paramUser);

    public  boolean deleteUser(int paramInt);

    public  List<UserStudent> getAll();
}

