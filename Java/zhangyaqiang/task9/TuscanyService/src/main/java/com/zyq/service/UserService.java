package com.zyq.service;

import com.zyq.pojo.User;
import org.oasisopen.sca.annotation.Remotable;


public interface UserService {
    void insert(User user);

    User selectByUserName(String username);

    User selectByTel(String telephone);

    User selectByEmail(String email);

    Integer selectIdById(Integer id);

    String selectPwdByUserName(String username);

    String selectPwdByTelephone(String telephone);

    String selectPwdByEmail(String email);

    void updateByUsername(String username, User user);

    String SendTelMsg(String telephone);

    String SendEmailMsg(String email);

    String verifyTelMsg(String telephone, String message);

    String verifyEmailMsg(String email, String message);
}
