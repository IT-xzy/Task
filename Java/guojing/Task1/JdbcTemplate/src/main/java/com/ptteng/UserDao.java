package com.ptteng;

import java.util.List;

public interface UserDao {
    public long insertUser(User user);
    public List<User> findAll();
    public List<User> findById(long id);
    public boolean updateUser(User user);
    public boolean deleteUser(long id);
}
