package service;

import pojo.User;

public interface UserService {
    boolean nameTest(String name);
    void insertUser(User user);
    boolean passwordTest(User user);
}
