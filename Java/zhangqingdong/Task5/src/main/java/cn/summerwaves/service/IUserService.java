package cn.summerwaves.service;

import cn.summerwaves.model.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;


public interface IUserService {
    void insertUser(User user);

    User selectUserByName(String username);

    String getCookieValueByName(HttpServletRequest request,String name) throws UnsupportedEncodingException;

    String setPasswordBySalt(String username,String password);
}
