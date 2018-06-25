package com.ssm.service;

import com.ssm.model.User;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;

/**
 * Created by Enzo Cotter on 18/4/2.
 */
@Remotable
public interface UserService {
    int addUser(User user);

    int deleteUser(int id);

    int updateUser(User user);

    User getById(int id);

    List<User> getAll();
}
