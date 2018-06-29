package com.ptteng.service;


import com.ptteng.model.Login;
import com.ptteng.model.User;
import java.util.List;

public interface UserService {
    //注册
    boolean register(User user) throws Exception;
    //身份验证
    long validateUser(Login login) throws Exception;
    List<User> getUserByName(String name) throws Exception;
    User getUserById(long id) throws Exception;
    //更新密码
    boolean updatePassword(User user) throws Exception;
    //注销用户
    boolean deleteUser(User user) throws Exception;
    //注册查询是否已存在相同用户名用户
    public boolean isExist(User user) throws Exception;
    //报名
    boolean update(User user) throws Exception;
}
