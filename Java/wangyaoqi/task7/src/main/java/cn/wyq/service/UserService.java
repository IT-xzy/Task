package cn.wyq.service;

import cn.wyq.pojo.User;

public interface UserService {
    void register(User user);
    User login(String userName, String password);
    User findUserNameAndPhone(String userName, String telephone);
    User findUserNameAndEmail(String userName, String email);
    User findUserName(String userName);
    User findPhone(String telephone);
    User findEmail(String email);
    User getSalt(String userName);
}
