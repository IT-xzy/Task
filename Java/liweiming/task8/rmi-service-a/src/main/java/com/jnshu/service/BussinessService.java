package com.jnshu.service;

import com.jnshu.entity.UserDTO;

/**
 * @program: Tiles
 * @description:
 * @author: Mr.Lee
 * @create: 2018-08-08 11:42
 **/

public interface BussinessService {

     void register(UserDTO userDTO);

     Boolean findByUserName(String username);

     UserDTO getByUsername(String username);

     UserDTO getByEmail(String username);

     UserDTO getByPhone (String username);


     UserDTO login(String username);

     Boolean update(UserDTO userDTO);

     Boolean alogin(UserDTO dto);
}
