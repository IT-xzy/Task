package com.jnshu.task4.mapper;

import com.jnshu.task4.beans.User;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Qualifier
public interface UserMapper {
    int addUser(User user);

    List<User> selectAllUser();

    User selectUserById(Integer id);

    int updateUserById(Integer id,User user);

    int delectUserById(Integer id);

    List<User> selectUserBySalaryDESC();
}
