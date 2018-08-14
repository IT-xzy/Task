package com.jnshu.service.impl;


import com.jnshu.dao.UserDao;
import com.jnshu.model.User;
import com.jnshu.model.UserCustom;
import com.jnshu.model.UserQv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("service")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;


//查找所有
    @Override
    public List<User> findUserAll() throws Exception {
        return userDao.findUserAll();
    }
//模糊查询
    @Override
    public List<User> findUserByCondition(UserQv userQv) throws Exception {
        System.out.println("rete" + userQv.toString());
        return userDao.findUserByCondition(userQv);
    }
//id查询

    @Override
    public UserCustom findUserById(int i) throws Exception {
        return userDao.findUserById(i);
    }



//插入
    @Override
    public int insertUser(User user) throws Exception {
        userDao.insertUser(user);
        return 1;
    }

//删除
    @Override
    public boolean deleteUser(long l) throws Exception {
        return userDao.deleteUser(l);
    }
//修改
    @Override
    public boolean updateUser(User user) throws Exception {
        return userDao.updateUser(user);
    }
//遍历
    @Override
    public void forList(List<User> user) {
        for (int i = 0; i < user.size(); i++) {
            System.out.println(user.get(i).toString());
        }
    }

    @Override
    public boolean test() {
        return false;
    }
}