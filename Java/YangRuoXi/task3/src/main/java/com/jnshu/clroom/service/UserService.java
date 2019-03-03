package com.jnshu.clroom.service;

import com.jnshu.clroom.beans.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
     boolean addUser(User user);

     boolean upadteUserById(Integer userId,String userName,String password,String userRole);

     User selectUserById(Integer userId);

     List<User> selectAllUser();

     Boolean delectUserById(Integer userId);

}
