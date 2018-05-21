package com.ycc.dao;

import com.ycc.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    User getUserById(int id);

    User getUserByName(String name);

    User getUserByNumber(int number);

    int addUser(List<User> userList);

    int updateUser(User user);

    int deleteUser(int id);

    List<User> getAllUser();
}
