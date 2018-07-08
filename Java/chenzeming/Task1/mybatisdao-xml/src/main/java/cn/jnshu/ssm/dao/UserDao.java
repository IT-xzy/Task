package cn.jnshu.ssm.dao;

import cn.jnshu.ssm.po.User;


public interface UserDao {

    //根据id查询用户
    public User findUserById(int id) throws Exception;

    //删除用户
    public void deleteUser(int id) throws Exception;

    //添加用户信息
    public void insertUser(User user) throws Exception;

}
