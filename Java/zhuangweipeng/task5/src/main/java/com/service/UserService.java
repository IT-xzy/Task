package com.service;

import com.entity.Excellent_Stu;
import com.entity.User;
import com.entity.User2;

import java.util.List;

public interface UserService {
    List<Excellent_Stu> getAll();

    List<Excellent_Stu> limit();

    /**
     * 判断用户是否存在
     *
     * @param name
     * @param password
     * @return
     */
    boolean judgeUser(String name, String password) throws Exception;

    /**
     * 保存token
     *
     * @param name
     * @return
     */
    String saveToken(String name) throws Exception;

    /**
     * 注册用户
     *
     * @param user
     */
    void addUser(User user);

    //查找数据库中用户
    public User findUserByName(String name);
}

