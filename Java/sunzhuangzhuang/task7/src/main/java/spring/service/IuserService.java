package spring.service;

import spring.model.User;

public interface IuserService {
    User query(User user);  //判断用户登陆
    void add(User user); //添加用户
    Long getName(String name);  //通过用户名获得登陆时间
    void reLogin(User user);  //根据用户更新登陆时间
    Boolean selectByName(String name); //登陆判断数据库中是否存在相同用户。
}
