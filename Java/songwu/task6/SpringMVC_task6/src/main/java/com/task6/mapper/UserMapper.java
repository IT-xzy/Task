package com.task6.mapper;

import com.task6.pojo.User;

import java.util.List;

public interface UserMapper {

    //查询首页的所有数据
    List<User> selectAll();

    //根据姓名模糊查询
    User selectByName(String name);

    //根据id删除
    boolean deleteById(int id);

    //    新增
    int insertUser(User user);

    //    动态修改
    boolean updateUser(User user);
}
