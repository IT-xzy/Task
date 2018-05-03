package com.ptteng.service.Impl;

import com.ptteng.dao.UserDao;
import com.ptteng.model.Login;
import com.ptteng.model.User;
import com.ptteng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    //注册
    @Override
    public boolean register(User user) throws Exception {
        return userDao.saveUser(user);
    }

    //用户身份验证
    @Override
    public boolean validateUser(Login login) throws Exception{
        List<User> users = null;
        Boolean result= null;
        System.out.println(login.getUsername());
        users = userDao.getUserByName(login.getUsername());
        users.size();
        if (users.size() != 0){
            for (User user : users) {
                if (login.getPassword().equals(user.getPassword())) {
                    result = true;
                } else {
                    result = false;
                }
            }
        }else {
            result=false;
        }

        return  result;
    }
    //更新密码
    @Override
    public boolean updatePassword(User user) throws Exception {
        return userDao.updateUser(user);
    }
    //注销用户
    @Override
    public boolean deleteUser(User user) throws Exception {
        return userDao.deleteUserById(user.getId());
    }


}
