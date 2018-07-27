package com.jnshu.tiles.service.impl;

import com.jnshu.tiles.dao.UserDTODAO;
import com.jnshu.tiles.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: Tiles
 * @description: 处理注册登录逻辑
 * @author: Mr.Lee
 * @create: 2018-07-04 09:57
 **/
@Service
public class BusinessServiceImpl {

    @Autowired
    UserDTODAO userDTODAO;

    /**
    * @Description: 注册
    * @Param: [userDto]
    * @return: void
    * @Author: Mr.Lee
    * @Date: 2018\7\4 0004
    */
    public void register(UserDTO userDTO){
        userDTODAO.add(userDTO);
    }

    public Boolean findByUserName(String username){
        return userDTODAO.findByUserName(username);
    }

    public UserDTO login(String username){
         return userDTODAO.checkout(username);
    }

}
