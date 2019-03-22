package com.jnshu.task7.service;

import com.jnshu.task7.beans.Login;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    int addlogin(Login login);

    boolean addLoginAndPwd(Login login);

    Login selectLoginByName(String loginName);

    // @Select("select * from login where id = #{id}")
    Login selectLoginById(Long id);

    Boolean checkLogin(Long id, String pwd);

    Long selectPwdByNameOrPhoneOrEmail(String value);

    Login selectLoginByEmail(String email);

}
