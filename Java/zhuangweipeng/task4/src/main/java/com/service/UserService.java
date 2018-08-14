package com.service;

import com.entity.User;
import com.entity.User2;

import java.util.List;

public  interface UserService{
    List<User> getAll();
    List<User> limit();

}

