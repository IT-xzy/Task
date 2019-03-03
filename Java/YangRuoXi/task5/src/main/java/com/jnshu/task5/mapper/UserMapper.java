package com.jnshu.task5.mapper;

import com.jnshu.task5.beans.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int addUser(User user);

    List<User> selectAllUser();

    User selectUserById(Integer id);

    int updateUserById(Integer id, User user);

    int delectUserById(Integer id);

    List<User> selectUserBySalaryDESC();
}
