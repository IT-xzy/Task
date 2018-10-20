package cn.wyq.service.impl;

import cn.wyq.mapper.UserMapper;
import cn.wyq.pojo.User;
import cn.wyq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user){
        userMapper.addUser(user);
    }

    @Override
    public User login(String userName, String password){
        return userMapper.findUserByNameAndPwd(userName,password);
    }

    @Override
    public User findUserNameAndPhone(String userName, String telephone){
        return userMapper.findUserByNameAndPhone(userName,telephone);
    }

    @Override
    public User findUserNameAndEmail(String userName, String email){
        return userMapper.findUserByNameAndEmail(userName,email);
    }

    @Override
    public User findUserName(String userName){
        return userMapper.findUserName(userName);
    }

    @Override
    public User findPhone(String telephone){
        return userMapper.findPhone(telephone);
    }

    @Override
    public User findEmail(String email){
        return userMapper.findEmail(email);
    }

    @Override
    public User getSalt(String userName){
        return userMapper.getSalt(userName);
    }
}
