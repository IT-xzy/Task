package com.jnshu.service;

import com.jnshu.model.User;


public interface UserService {
  User findById(Integer id);
  String update(User addInfo);
  User login(User user);
  String addInfo(User addInfo);
}
