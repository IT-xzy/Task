package service;

import pojo.User;

public interface UserService {
    void addUser(User user) throws Exception;
    void deleteUserById(String id) throws Exception;
    User getUserById(String id) throws Exception;
    User getUser(User user) throws Exception;
    void updateUser(User user) throws Exception;
}
