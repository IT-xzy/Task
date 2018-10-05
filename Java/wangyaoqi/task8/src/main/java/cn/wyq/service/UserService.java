package cn.wyq.service;

import cn.wyq.pojo.User;

public interface UserService {
    void register(User user);
    User login(String userName, String password);
    User findUserName(String userName);
    User getSalt(String userName);
}
