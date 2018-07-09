package com.jnshu.tiles.service;

import com.jnshu.tiles.entity.User;
import com.jnshu.tiles.mapper.UserDao;
import com.jnshu.tiles.tools.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: Tiles
 * @description: 处理注册登录逻辑
 * @author: Mr.Lee
 * @create: 2018-07-04 09:57
 **/
@Service
public class BusinessServiceImpl {

    @Autowired
    UserDao userDao;

    /**
    * @Description: 注册
    * @Param: [userDto]
    * @return: void
    * @Author: Mr.Lee
    * @Date: 2018\7\4 0004
    */
    public void register(User user){
        userDao.add(user);
    }


    public Boolean findByUserName(String username){
        return userDao.findByUserName(username);
    }


    public User login(String username){
         return userDao.checkout(username);
    }

}
