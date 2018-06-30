package cn.jnshu.zcm.dao;

import cn.jnshu.zcm.po.User;

public interface UserDao {

    //根据id查询用户
    public User findUserById(int id) throws Exception;

    //添加用户信息
    public void insertUser(User user) throws Exception;

    //删除用户信息
    public void deleteUser(int id)throws Exception;

}
