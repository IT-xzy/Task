package com.service;


import com.Pojo.User;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface UserService {

    void message(String userTel);


    void insert(User user);

    JSONObject add(String verifyCode, User user);

    void delete(String userId);

    User selectById(String userId);

    List<User> selectAll();

    boolean update(User user);

    JSONObject sendMail(String userMail);


    JSONObject sendMail(String userMail, HttpServletRequest httpServletRequest, String userId);
}
