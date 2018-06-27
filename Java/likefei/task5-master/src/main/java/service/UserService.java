package service;

import pojo.User;

public interface UserService {
    void insert(User user);

    User getbyname(String name);

    boolean passwordtest(String name,String password);

    boolean nametest(String name);
}
