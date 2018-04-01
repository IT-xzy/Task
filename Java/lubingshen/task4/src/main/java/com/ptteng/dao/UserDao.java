package com.ptteng.dao;

import com.ptteng.bean.User;

public interface UserDao {
    //查询记录总条数
    public int selectCount();
    //根据id查询用户信息
    public User findById(long id) throws Exception;
    //根据姓名模糊查询
    public User findByName(String name) throws Exception;
    //添加用户信息
    public boolean insertUser(User user) throws Exception;
    //删除用户信息
    public boolean deleteUser(long id) throws Exception;
    //更新用户信息
    public boolean modifyLoginTime(User user) throws Exception;
}
