package com.ptteng.service;

import com.ptteng.entity.User;

public interface UserService {
    Long insertUser(User user);

    User findById(Long id);

    Boolean updateUser(User user);

    Boolean deleteUser(Long id);
}
