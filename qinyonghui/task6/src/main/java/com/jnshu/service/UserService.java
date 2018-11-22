package com.jnshu.service;

import com.jnshu.entity.User;

public interface UserService {
    public Boolean register(User user);
    public  Boolean login(User user);
}
