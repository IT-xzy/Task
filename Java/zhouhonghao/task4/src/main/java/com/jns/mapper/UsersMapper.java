package com.jns.mapper;

import com.jns.pojo.Users;

import java.util.List;

public interface UsersMapper {
int add(Users users);
int update(Users users);
Users findByName(String phone);
List<Users> list();
}
