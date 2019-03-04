package com.jnshu.task6.service;

import com.jnshu.task6.beans.Login;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    int addlogin(Login login);

    boolean addLoginAndPwd(Login login);

    Login selectLoginByName(String loginName);

    // @Select("select * from login where id = #{id}")
    Login selectLoginById(Integer id);

    Boolean checkLogin(Integer id,String pwd);


}
