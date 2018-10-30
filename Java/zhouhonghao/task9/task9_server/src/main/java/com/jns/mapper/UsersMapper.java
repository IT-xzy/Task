package com.jns.mapper;

import com.jns.entity.Users;

import java.util.List;

public interface UsersMapper {
    //接受返回值，对应xml文件中的sql语句
    //方法名与对应的xml文件中id保持一致

    //添加
    int add(Users users);
    //更新
    int update(Users users);
    int updateOther(Users users);
    //根据id，搜索用户
    Users getByPhone(String phone);
    //根据name，搜索用户
    Users getByName(String name);
    //接受所有用户数据
    List<Users> list();
}
