package com.jnshu.task5.service;

import com.jnshu.task5.beans.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    int addUser(User user);

    List<User> selectAllUser();

    User selectUserById(Integer id);

    int updateUserById(Integer id, User user);

    int delectUserById(Integer id);

    List<User> selectUserBysalaryDESC();

}
