package cn.wp.service;

import cn.wp.entity.User;

import java.util.List;

public interface UserService {
  boolean insert(User record);

  Long selectByName(String name);

  List<User> selectAll();

  Long selectByCondition(String name, String password);

  User selectById(Long id);
}
