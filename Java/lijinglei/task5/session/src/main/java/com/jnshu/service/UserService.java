package com.jnshu.service;

import com.jnshu.model.User;


public interface UserService {
  User findById(Integer id);
  String update(User addInfo);
  boolean login(User user);
  String addInfo(User addInfo);
  User selectByName(String userName);
  String addTime(User login);
}
