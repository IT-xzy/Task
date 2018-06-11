package task2.service;

import task2.pojo.User;

public interface UserService {
    //用户注册
    void regist(User user);
    //用户登录
    User login(String username, String password);

}
