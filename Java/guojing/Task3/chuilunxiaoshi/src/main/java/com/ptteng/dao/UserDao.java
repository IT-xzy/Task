package com.ptteng.dao;

import com.ptteng.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User check(User user);

    long register(User user);
}
