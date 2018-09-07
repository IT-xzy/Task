package com.jnshu.service.impl;

import com.jnshu.dao.UserMapper;


import com.jnshu.model.User;
import com.jnshu.service.UserService;
import com.jnshu.tools.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    public UserMapper getESMapper() {
        return userDao;
    }

    public void setESMapper(UserMapper UserDao) {
        this.userDao = UserDao;
    }

    @Override
    public User findById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public User selectByName(String userName) {

        return userDao.selectByName(userName);
    }

    @Override
    public String addTime(User login) {
        if (userDao.updateByName(login) == 1) {
            return "更新成功";
        }
        return "更新失败";
    }

    @Override
    public String uploadImage(@Param("userName")String userName, @Param("userImage")String userImage) {
        if (userDao.updateImageByName(userName,userImage) == 1){
            return "图片更新成功";
        }
        return "图片更新失败";
    }

    @Override
    public String update(User addInfo) {
        if (userDao.updateByPrimaryKeySelective(addInfo) == 1) {
            return "更新成功";
        }
        return "更新失败";
    }

    @Override
    public boolean login(User user) {
        String password = user.getPassword();
        String salt = userDao.selectByName(user.getUserName()).getSalt();
        String psSalt = MD5Util.generate(password,salt);
        return  psSalt.equals(userDao.selectByName(user.getUserName()).getPassword());
    }


    @Override
    public String addInfo(User addInfo) {
        if (userDao.insertSelective(addInfo) == 1) {
            return "注册成功";
        }
        return "注册失败";
    }
}