package com.dao;

import com.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    User selectUser(int id);

    void insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);

    List<User> getAll();
}
