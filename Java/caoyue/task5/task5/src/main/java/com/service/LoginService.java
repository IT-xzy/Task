package com.service;

import com.POJO.User;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 登录
 * @create: 2018/5/8 下午3:17
 */

public interface LoginService {
    int deleteByPrimaryKey(Integer id);
    
    int insert(User record);
    
    int insertSelective(User record);
    
    User selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(User record);
    
    int updateByPrimaryKey(User record);
    
    User selectByUser(User user);
    
    User findUserByname(String name);
}
