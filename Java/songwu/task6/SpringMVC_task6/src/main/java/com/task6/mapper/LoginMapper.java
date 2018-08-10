package com.task6.mapper;

import com.task6.pojo.Person;

/**
 * Create by SongWu on 2018/7/2
 */
public interface LoginMapper {
//根据用户名查询
   Person selectLogin(String username);

//新增数据
   int insertLogin(Person person);

   //   根据用户名修改密码
   boolean updateByUsername(Person person);

}
