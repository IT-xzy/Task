package com.ptteng.dao;


import com.ptteng.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    Long insertUser(User user);
    User findById(Long id);
    Boolean updateUser(User user);
    Boolean deleteUser(Long id);
}
