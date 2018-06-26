package dao;

import org.springframework.stereotype.Repository;
import pojo.User;

/**
 * 用户的增删查改
 */
@Repository
public interface UserMapper {
    void addUser(User user);
    void deleteUserById(String id);
    User getUserById(String id);
    User getUser(User user);
    User getUserByName(String name);
    void updateUser(User user);
    void updatePhoto(User user);
}
