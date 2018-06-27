package dao;

import pojo.User;

public interface UserDao {
    //注册暂时不实现
//    void register(User user);
    User validateUser(String username, String password);

    void updateTimeById(long id);

    User selectById(long id);
}
