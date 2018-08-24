package com.service;

import com.mapper.UserMapper;
import com.model.Page;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author qmz
 * @Description
 * @Data 2018/7/4$ 18:34$
 **/
@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserMapper userMapper;
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public boolean deleteById(User user) {
        return userMapper.deleteById(user);
    }

    @Override
    public User selectById(User user) {
        return userMapper.selectById(user);
    }

    @Override
    public int total() {
        return userMapper.total();
    }

    @Override
    public List<User> selectAll(Page page) {
        return userMapper.selectAll(page);
    }

    @Override
    public boolean deleteByName(User user) {
        return userMapper.deleteByName(user);
    }

    @Override
    public int updateTypeByName(User user) {
       return userMapper.updateTypeByName(user);
    }

    @Override
    public User selectByName(User user) {


        user=userMapper.selectByName(user);


        return user;
    }
}
