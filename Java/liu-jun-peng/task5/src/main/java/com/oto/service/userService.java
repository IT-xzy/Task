package com.oto.service;

import com.oto.pojo.user;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/9 上午9:51
 */

public interface userService {
    void regist(user user);
    boolean login(String username, String Password);
    

}
