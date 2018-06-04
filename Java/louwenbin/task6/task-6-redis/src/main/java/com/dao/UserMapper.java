package com.dao;

import com.entity.User;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public  interface UserMapper
{
  public  User selectUser(int paramInt);

  public  void insertUser(User paramUser);

  public  boolean updateUser(User paramUser);

  public  boolean deleteUser(int paramInt);

  public  List<User> getAll();
}

