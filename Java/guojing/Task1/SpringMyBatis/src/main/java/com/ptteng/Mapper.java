package com.ptteng;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Mapper {

    public long insertUser(User user);
    public List<User> findAll();
    public List<User> findById(long id);
    public boolean updateUser(User user);
    public boolean deleteUser(long id);
}
