package service;

import pojo.User;

public interface UserService {
    void insert(User user);

    User getbyname(String name);

    boolean passwordtest(User user);

    boolean nametest(String name);
}
