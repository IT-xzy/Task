package com.ptteng.service;


import com.ptteng.model.Login;
import com.ptteng.model.User;

public interface UserService {
    //注册
    boolean register(User user) throws Exception;
    //身份验证
    boolean validateUser(Login login) throws Exception;
    //更新密码
    boolean updatePassword(User user) throws Exception;
    //注销用户
    boolean deleteUser(User user) throws Exception;


}
