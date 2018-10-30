package com.wyz.task5.serviec;

import com.wyz.task5.domain.entity.Users;

public interface UsersService {

    int insert(Users user);

    int deleteByName(String username);

    int update(Users user);

    Users getByName(String username);

    int updateloginTime(Users user);
}
