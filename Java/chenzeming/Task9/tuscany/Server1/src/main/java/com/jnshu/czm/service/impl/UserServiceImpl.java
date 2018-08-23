package com.jnshu.czm.service.impl;


import com.jnshu.czm.dao.UserDao;
import com.jnshu.czm.model.PageBean;
import com.jnshu.czm.model.User;
import com.jnshu.czm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;


public class UserServiceImpl implements UserService {

    private static Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;


    @Override
    //添加用户
    public void insertUser(User user) {
        logger.info("\n调用服务器1");
        userDao.insertUser(user);
    }


    @Override
    //删除用户
    public boolean deleteUserById(int id) {
        logger.info("\n调用服务器1");
        return userDao.deleteUserById(id);
    }

    //修改用户
    @Override
    public boolean updateUser(User user) {
        logger.info("\n调用服务器1");
        return userDao.updateUser(user);

    }

    @Override
    //单条查询
    public User findUserById(int userId) {
        logger.info("\n调用服务器1");
        User user = userDao.findUserById(userId);
        return user;
    }


    //查询全部
    @Override
    public List<User> findAll() {
        logger.info("\n调用服务器1");
        List<User> user = userDao.findAll();
        return user;
    }

    //查询记录条数
    @Override
    public int selectCount(){
        logger.info("\n调用服务器1");
        return userDao.selectCount();
    }


    //分页
    @Override
    public PageBean<User> findByPage(int currentPage){
        logger.info("\n调用服务器1");
        HashMap<String,Object> map = new HashMap<>();
        PageBean<User> pageBean = new PageBean<>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = userDao.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<User> lists = userDao.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }

    @Override
    public void test() {
        logger.info("\n调用服务器1的方法");
    }
}

