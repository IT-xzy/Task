package com.jnshu.model;

import java.io.Serializable;
import java.util.List;

/**
 * @program: taskTwo
 * @description: User集合对象
 * @author: Mr.xweiba
 * @create: 2018-05-21 10:33
 **/

public class UserList implements Serializable{
    private List<UserCustom> userList;

    public List<UserCustom> getUserList() {
        return userList;
    }

    public void setUserList(List<UserCustom> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "userList=" + userList +
                '}';
    }
}
