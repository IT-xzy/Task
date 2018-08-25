package com.task8.mapper;

import com.task8.pojo.Person;

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

   //更新手机号
   boolean updatePhone(Person person);

   //   动态更新支持图片，手机号，邮箱
   boolean updatePerson(Person person);
}
