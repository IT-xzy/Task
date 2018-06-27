package com.aaa.dao;

import com.aaa.model.User;

import java.util.List;
//创建dao类接口，封装具体方法实现，只提供抽象方法
public interface UserDAO {
//    通过传入方法体参数完成增删改
    public int insert(User user);

    public int update(User user);

    public int delete(int id);

    public User queryById(int id);
//用list集合类，添加查询结果集
    public List<User> queryAll();

    public void insertBatch(User user);
}
