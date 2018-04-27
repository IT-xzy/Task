package com.ssm.dao;

import com.ssm.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Enzo Cotter on 18/4/2.
 */
@Repository
public interface UserMapper {
    int addUser(User user);

    int deleteUser(int id);

    int updateUser(User user);

    User getById(int id);

    List<User> getAll();
}
