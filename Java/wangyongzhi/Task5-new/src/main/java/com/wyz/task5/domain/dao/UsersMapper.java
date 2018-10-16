package com.wyz.task5.domain.dao;


import com.wyz.task5.domain.entity.Users;

public interface UsersMapper {

    public int insert(Users user);

    public int deleteByName(String username);

    public int update(Users user);

    public Users getByName(String username);

    public int updateloginTime(Users user);

}
