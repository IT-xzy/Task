package com.fgh.Mybatis.service;


import com.fgh.Mybatis.dao.UserMapper;
import com.fgh.Mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;



//    @Service服务层组件，用于标注业务层组件,表示定义一个bean，
//自动根据bean的类名实例化一个首写字母为小写的bean
//getBean的默认名称是类名(头字母小写),自定义@Service(“ ”)指定
@Service
public class UserServiceImpl implements UserService {
        @Autowired
        private UserMapper userMapper;

        public  List<User> findUserBy(User user)throws Exception{
            return userMapper.findUserBy(user);
        }

    public boolean insertUser(User user)throws Exception{
        return userMapper.insertUser(user);
    }
    public boolean delUser(int id)throws Exception{
        return userMapper.delUser(id);
    }

    public boolean updateUser(User user)throws Exception{
        return  userMapper.updateUser(user);
    }


    public List<User> findAll()throws Exception{
        return userMapper.findAll();
    }
}
