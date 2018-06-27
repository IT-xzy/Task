package com.ptteng.service;

import com.ptteng.entity.UserStudent;
import net.rubyeye.xmemcached.exception.MemcachedException;

import java.util.List;
import java.util.concurrent.TimeoutException;

public abstract interface UserServiceStudent
{
  public abstract UserStudent selectUser(int paramInt) throws InterruptedException, MemcachedException, TimeoutException;

  public abstract void insertUser(UserStudent paramUser);

  public abstract boolean updateUser(UserStudent paramUser);

  public abstract boolean deleteUser(int paramInt);

  public abstract List<UserStudent> getAll();
}

