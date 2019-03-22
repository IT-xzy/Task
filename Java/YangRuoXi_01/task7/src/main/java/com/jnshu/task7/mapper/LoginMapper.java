package com.jnshu.task7.mapper;

import com.jnshu.task7.beans.Login;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    Integer insertLogin(Login login);

    Login selectLoginById(Long id);

    Login selectLoginByName(String loginName);

    Boolean insertLoginNameAndPwd(Login login);

    Login selectPwdByNameOrPhoneOrEmail(String value);

    Boolean updateLoginByEmail(String loginName,String email);

    Login selectLoginByEmail(String email);

}
