package com.task8.rmi;

import com.task8.service.UserService;
import com.task8.util.RmiServerUtil;

/**
 * Create by SongWu on 2018/8/18
 */

public class RmiTest2 {
    public static void main(String[] args) {
        RmiServerUtil rmiServerUtil = new RmiServerUtil();
        UserService userService = rmiServerUtil.getUserService();
        System.out.println(userService.selectAll());


    }


}
