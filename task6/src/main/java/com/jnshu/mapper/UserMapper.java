package com.jnshu.mapper;

import com.jnshu.entity.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User>{
  public Long  addOne(User user);
  public Boolean findOne(User user);
  public User findByName(String username);
  public int insert(User user);
}