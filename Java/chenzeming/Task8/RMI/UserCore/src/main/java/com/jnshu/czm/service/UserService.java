package com.jnshu.czm.service;

import com.jnshu.czm.model.PageBean;
import com.jnshu.czm.model.User;

import java.util.List;

public interface UserService {

    public void insertUser(User user);

    public boolean deleteUserById(int id);

    public boolean updateUser(User user);

    public User findUserById(int userId);

    public List<User> findAll();

    /**
     * 查询用户记录总数
     */
    public int selectCount();

    /**
     * 分页操作，调用findByPage limit分页方法
     */
    public PageBean<User> findByPage(int currentPage);

    public void test();
}

