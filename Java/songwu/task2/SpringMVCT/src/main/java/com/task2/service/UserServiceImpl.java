package com.task2.service;

import com.task2.mapper.UserMapper;
import com.task2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService  {

    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl() {
        super();
    }

//查询总数
    @Override
    public int findUserCount() throws Exception {

        return userMapper.findUserCount();
    }
//分页查询
    @Override
    public List<User> findUserByPage(int start, int pageSize) throws Exception {
        List<User> list = userMapper.findUserByPage(start, pageSize);
        return list;
    }

//新增

    @Override
    public long insertUser(User user) {
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        userMapper.insertUser(user);

        return user.getId();
    }
//综合更改
    @Override
    public boolean updateUser(User user) {
        user.setUpdateAt(System.currentTimeMillis());
        return userMapper.updateUser(user);
    }
//根据id查询
    @Override
    public User findUserById(long id) {
        return userMapper.findUserById(id);
    }
//根据id删除
    @Override
    public boolean deleteUserById(long id) {
        return userMapper.deleteUserById(id);
    }
//综合查询
    @Override
    public List<User> selectUser(User user) {
        return userMapper.selectUser(user);
    }
}
