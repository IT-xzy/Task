package com.jnshu.service.impl;


import com.jnshu.mapper.UserMapper;
import com.jnshu.model.User;
import com.jnshu.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override

    public int insert(User user){
        return userMapper.insert(user);
    }

    public User selectById(Long id){return userMapper.selectById(id);}

    public List<User> selectByName(String name){
        return userMapper.selectByName(name);
    };

    public List<User> selectByCondition(@Param("name") String name, @Param("password") String password){
        return userMapper.selectByCondition(name, password);
    }
    public  List<User> selectByPhone(@Param("phone") String phone, @Param("code") String code){
        return userMapper.selectByPhone(phone, code);
    }
    public  boolean insertByPhone(@Param("phone") String phone, @Param("code") String code){
        return userMapper.insertByPhone(phone, code);
    }

}
