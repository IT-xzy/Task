package com.ptteng;

import java.util.List;

public interface UserDao {
    long insertUser(User user);

    List<User> findAll();

    List<User> findById(long id);

    boolean updateUser(User user);

    boolean deleteUser(long id);
}
