package com.jnshu.dao;

import com.jnshu.model.User;

import java.util.List;

public interface UserDao {
   /* 查找所有用户 */
List<User> findUserAll() throws Exception;
List<User> findUserByCondition(String s) throws Exception;
User findUserById(int i) throws  Exception;
      //插入
    int insertUser(User user) throws Exception;
    //删除
   boolean deleteUser(Long id) throws  Exception;
   //更新
   boolean updateUser(User user) throws Exception;

}
