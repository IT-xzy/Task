package com.ptteng.dao.mapping;

import com.ptteng.entity.User;

public interface UserMapper {

    User selectUser(int id);

    void insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);
}
