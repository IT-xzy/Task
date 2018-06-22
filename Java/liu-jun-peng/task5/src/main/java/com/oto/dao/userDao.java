package com.oto.dao;

import com.oto.pojo.user;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/9 上午9:31
 */

public interface userDao {

     void addUser(user user);
     
     user selectByName(String username);
    
    
}
