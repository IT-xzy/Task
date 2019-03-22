package com.jnshu.task6.mapper;

import com.jnshu.task6.beans.Login;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    int insertLogin(Login  login);

    Login selectLoginById(Integer id);

    Login selectLoginByName(String loginName);

    Boolean insertLoginNameAndPwd(Login login);

}
