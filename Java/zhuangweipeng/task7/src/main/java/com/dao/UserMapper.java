package com.dao;

import com.entity.Excellent_Stu;
import com.entity.User;
import com.service.UserService;
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
/**
* @Description:判断用户名是否存在
* @Author: Sometimes
* @Date:
*/
  User findUserByName(String name);

/**
* @Description:  判断用手机号码是否存在
* @Author: Sometimes
* @Date:
*/
User finUserByPhone(String phone);

/**
* @Description:  判断邮箱是否已经注册了
* @Author: Sometimes
* @Date:
*/
User findUserByEmail(String email);

/**
* @Description:  添加头像
* @Author: Sometimes
* @Date:
*/
Boolean updateUserByName(String name,String photo);

/**
* @Description:  查询显示头像
* @Author: Sometimes
* @Date:
*/

String findPhotoByName(String name);

/**
* @Description:  查询用户存不存在
* @Author: Sometimes
* @Date:
*/

Boolean judgeUserExist(String name);
}

