package com.iceneet.service;

import com.iceneet.entity.User;

public interface Userservice {
    int insertSelective(User record);

    int registerUser(User user);

    User userMatch(User user);

    User selectByName(String name);
}
