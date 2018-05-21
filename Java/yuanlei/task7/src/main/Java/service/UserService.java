package service;

import pojo.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    boolean nameTest(String name);
    void insertUser(User user,String icon);
    boolean passwordTest(User user);
    boolean  checkCode(String code,String e_code,HttpSession session);
}
