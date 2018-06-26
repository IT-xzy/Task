package com.ssm.service;

import com.ssm.model.UserEmailReg;

import java.util.List;

public interface UserEmailRegService {

    int addUserEmail(UserEmailReg userEmailReg);

    UserEmailReg getById(Long id);

    UserEmailReg getByName(String e_name);

    List<UserEmailReg> getAllEmailReg();
}
