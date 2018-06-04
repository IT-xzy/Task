package dao;

import pojo.User;

/**
 * 用户的增删查改
 */
public interface UserMapper {
    void addUser(User user);
    void deleteUserById(int id);
    User getUserById(int id);
    User getUser(User user);
    void updateUser(User user);
}
