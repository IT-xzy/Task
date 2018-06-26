package com.ptteng.dao;

import com.ptteng.entity.UserStudent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface UserMapperStudent
{
  public  UserStudent selectUser(int paramInt);

  public  void insertUser(UserStudent paramUser);

  public  boolean updateUser(UserStudent paramUser);

  public  boolean deleteUser(int paramInt);

  public  List<UserStudent> getAll();
}

