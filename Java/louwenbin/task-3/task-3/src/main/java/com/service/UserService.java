package com.service;

import com.entity.User;
import java.util.List;

public abstract interface UserService
{
  public abstract User selectUser(int paramInt);

  public abstract void insertUser(User paramUser);

  public abstract boolean updateUser(User paramUser);

  public abstract boolean deleteUser(int paramInt);

  public abstract List<User> getAll();
}

