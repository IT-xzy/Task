package com.jnshu.service;

import com.jnshu.mapper.UserMapper;
import com.jnshu.model.User;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;
@Remotable
public interface UserService {
    List<User> selectAll();
}
