package com.longhang.server;

import com.longhang.model.User;

import java.util.ArrayList;

public interface UserService {
    String getSelectByName(String name);//根据用户名获取密码
    Long getLoginTimeByName(String name);//根据用户名获取登录时间
    ArrayList<String> getGetAllName();//获取所有用户名
    User getSelects(String name);//获取用户信息
    void getInsert(String name,String password,String phone,Long create_at,Long logintime);//添加用户
    void getUpdataByName(String name,Long logintime);//更新时间
    void getUpdataByName1(String name,Long logintime);//更新用户登录时间
    void getUpdate(String name,String password,String phone,Long id);//更新用户
}
