package com.opt.service.impl;


import com.opt.dao.mapper.UserMapper;
import com.opt.model.Page;
import com.opt.model.User;
import com.opt.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByPhone(long phone){
        return userMapper.findByPhone(phone);
    }

    @Override
    public User findByEmail(String email){
        return userMapper.findByEmail(email);
    }

    @Override
    public int findAllCount(){
        return userMapper.findAllCount();
    };

    @Override
    public List<User> findByUser(User user) {
        return userMapper.findByUser(user);
    }

    @Override
    public int updateOne(User user) {
        return userMapper.updateOne(user);
    }

    @Override
    public int insertOne(User user) {
        userMapper.insertOne(user);
        return user.getId();
    }

    @Override
    public int deleteOne(int id) {
        return userMapper.deleteOne(id);
    }

    @Override
    public Page<User> findByPage(int nowpage,int pagesize) {
        HashMap<String,Object> hashMap = new HashMap();
        Page<User> page = new Page<>();

//        每页记录数
        int pageSize = pagesize;

//        封装当前页
        page.setCurrPage(nowpage);

//        封装每页记录数
        page.setPageSize(pageSize);

//        获取总记录数封装
        int totalC = userMapper.findAllCount();
        page.setTotalConut(totalC);

//        向上取整 获取总页数
        double totalP = totalC;
        Double dbc = Math.ceil(totalP/pageSize);
        page.setTotalPage(dbc.intValue());

//        设置页面limit start size
        logger.info(hashMap.put("nowpage",(nowpage-1)*pageSize));
        logger.info(hashMap.put("pagesize",page.getPageSize()));
        page.setPages( userMapper.findPage(hashMap));

        return page;
    }
}
