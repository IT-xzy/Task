package com.service;

import com.entity.User;
import net.rubyeye.xmemcached.exception.MemcachedException;

import java.util.List;
import java.util.concurrent.TimeoutException;

public  interface UserService
{
  public  User selectUser(int paramInt) throws InterruptedException, MemcachedException, TimeoutException;

  public  void insertUser(User paramUser) throws InterruptedException, MemcachedException, TimeoutException;

  public  boolean updateUser(User paramUser) throws InterruptedException, MemcachedException, TimeoutException;

  public  boolean deleteUser(int paramInt) throws InterruptedException, MemcachedException, TimeoutException;

  public  List<User> getAll() throws InterruptedException, MemcachedException, TimeoutException;
}

