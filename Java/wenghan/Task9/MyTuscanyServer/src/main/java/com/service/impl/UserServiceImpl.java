package com.service.impl;

import com.Plug.PageBean;
import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;

    private static Logger logger=Logger.getLogger(UserServiceImpl.class);

    @Override
    //添加一个用户
    public boolean addUser(User user) {

        return userMapper.insertUser(user) != 0;
    }

    //减少一个用户
    @Override
    public boolean cutUserById(long id) {

        return userMapper.deleteUserById(id) != 0;
    }

    @Override
    //修改一个用户
    public boolean reviseUserById(User user) {

        return userMapper.updateUserById(user) != 0;
    }

    @Override
    //查询一个用户
    public User queryUserById(long id) {
        logger.info("值为："+id);
        return userMapper.selectUserById(id);
    }

    //查询所有用户
    @Override
    public List<User> queryUser() {
        return userMapper.selectUser();
    }

    //分页
    public PageBean findAllUserWithPage(int pageNum, int pageSize){
        //在这里要将pageBean中的数据创建好，然后将该对象传回去
        //先要从数据库中获取所有用户的数据量有多少，获得totalRecord
        List<User> allUser=userMapper.selectUser();
        int totalRecord=allUser.size();
        //有了三个初始数据，将能够创建PageBean对象了
        PageBean pageBean=new PageBean(pageNum,pageSize,totalRecord);
        //获取pageBean对象中的starIndex
        int starIndex=pageBean.getStartIndex();
        //有了starIndex和pageSize,就可以拿到每页的数据了
        pageBean.setList(userMapper.selectPage(starIndex,pageSize));
        logger.info(pageBean);
        return pageBean;
    }

}
