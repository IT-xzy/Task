package com.student.mapping;

import com.student.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
//    获取所有信息
      List<User> getAllUser()throws Exception;
//    根据id获得对象信息
      List<User> getUserMore(User user)throws Exception;
//    添加信息
      int addUser(User user)throws Exception;
//    根据id删除信息
      boolean deleteUser(int id)throws Exception;
//    更新信息
      boolean updateUser(User user)throws Exception;

}
/**/