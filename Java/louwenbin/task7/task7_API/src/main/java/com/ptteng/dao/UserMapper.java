package com.ptteng.dao;

import com.ptteng.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface UserMapper{
  List<User> getAll();
}

