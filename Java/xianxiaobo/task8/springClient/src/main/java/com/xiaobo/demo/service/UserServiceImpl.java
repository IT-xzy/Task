package com.xiaobo.demo.service;

import com.github.pagehelper.PageHelper;
import com.xiaobo.demo.dao.UserMapper;
import com.xiaobo.demo.pojo.Page;
import com.xiaobo.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectByPrimaryKey(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<User> getAllUser(Integer page, Integer size){
        PageHelper.startPage(page,size);
        List<User> userList = userMapper.getAll();
        Integer total = userMapper.getTotal();
        Page<User> pageData = new Page<>(page,size,total);
        pageData.setItems(userList);
        return pageData.getItems();
    }
}
