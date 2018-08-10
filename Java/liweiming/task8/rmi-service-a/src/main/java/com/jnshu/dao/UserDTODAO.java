package com.jnshu.dao;

import com.jnshu.entity.UserDTO;

/**
 * @program: Tiles
 * @description: 用户管理逻辑
 * @author: Mr.Lee
 * @create: 2018-07-04 09:45
 **/
public interface UserDTODAO {
//    添加用户到数据库
    void add(UserDTO userDTO);
//    登录时，校验用户名和密码
    UserDTO checkout(String username);
//    注册时，校验用户名是否存在
    Boolean findByUserName(String username);

    UserDTO getByUsername(String username);
    UserDTO getByEmail(String email);
    UserDTO getByPhone(String phone);
    Boolean update(UserDTO userDTO);
}
