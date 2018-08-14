package com.jnshu.tiles.mapper;

import com.jnshu.tiles.entity.User;

/**
 * @program: Tiles
 * @description: 用户管理逻辑
 * @author: Mr.Lee
 * @create: 2018-07-04 09:45
 **/
public interface UserDao {
//    添加用户到数据库

    void add(User user);
//    登录时，校验用户名和密码

    User checkout(String username);
//    注册时，校验用户名是否存在

    Boolean findByUserName(String username);
}
