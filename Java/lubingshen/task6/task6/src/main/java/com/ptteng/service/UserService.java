package com.ptteng.service;

import com.ptteng.pojo.model.User;

public interface UserService {
    //查询所有在学学员的数量
    Integer count();
    //插入一个管理员信息并且返回主键
    Long register(User user) throws Exception;
    //删除一个学员信息
    boolean delete(Long primeKey) throws Exception;
    //通过主键来查询一个学员
    User findByPrimeKey(Long primeKey) throws Exception;
    //通过姓名模糊查询
    User query(String name) throws Exception;
    //更新信息
    boolean modify(User user) throws Exception;
}
