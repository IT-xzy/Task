package com.dao;

import com.entity.User;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public abstract interface UserMapper
{
  public abstract User selectUser(int paramInt);

  public abstract void insertUser(User paramUser);

  public abstract boolean updateUser(User paramUser);

  public abstract boolean deleteUser(int paramInt);

  public abstract List<User> getAll();
}

