package com.dao;

import com.entity.Excellent_Stu;
import com.entity.User;
import com.entity.User2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface UserMapper{
  List<Excellent_Stu> getAll();
  List<Excellent_Stu> limit();
  /**
   * 通过取出用户来获得用户的相关信息
   * @param name
   * @return
   */
  User judgeUser(String name);

  /**
   * 注册用户
   * @param user
   */
  void addUser(User user);

  User findUserByName(String name);
}

