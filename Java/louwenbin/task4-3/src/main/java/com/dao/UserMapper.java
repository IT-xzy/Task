package com.dao;

import com.entity.User;
import com.entity.User2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface UserMapper{
  List<User> getAll();
}

