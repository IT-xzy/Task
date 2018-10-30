package com.task5.service.impl;

import com.task5.mapper.UserDao;
import com.task5.pojo.User;
import com.task5.service.UserService;
import com.task5.until.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;
    @Autowired
    private MD5 md5;

    @Override
    public String login(User user) throws Exception {
        //登录判断
        User user1 = userDao.findUserByName(user.getUserName());
        if (user1 == null){
            return "此用户不存在！";
        }
//        if (user.getUserName()==null){
//            return "用户名错误，请重试";
//        }
        String salt = user1.getSalt();
        String key = md5.md5encryption(user.getPassword()+salt);
        if (key ==null){
            return "密码错误，请重试";
        }
        user.setPassword(key);
        if (userDao.checkUser(user.getUserName(),user.getPassword())!=null){
            return "true";
        }else
        return "用户名和密码不匹配";
    }

    public String check(User user)throws Exception{
        if (user.getUserName().trim().length()<1){
            return "用户名不符合要求";
        }
        if (user.getPassword().trim().length()<3){
            return "密码不符合要求";
        }
        if (userDao.findUserByName(user.getUserName())==null){
            return "true";
        }
        else
            return "此用户名已被注册";
    }

    @Override
    public String register(User user) throws Exception {
        String message = check(user);
        if (message.equals("true")){

            String[] key = md5.encryption(user.getPassword());
            if (key[0] == null) {
                return "系统出错，请重试";
            }
            user.setPassword(key[0]);
            user.setSalt(key[1]);
            user.setCreateAt(System.currentTimeMillis());
            user.setUpdateAt(System.currentTimeMillis());
            //注册该用户
            if (userDao.addUser(user) > 0) {
                return "true";
            } else {
                return "注册失败，请稍后尝试";
            }
        } else {
            return message;
        }

    }
}
