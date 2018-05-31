package com.ssm.service;

import com.ssm.model.UserRegister;

import java.util.List;

public interface UserRegisterService {

    int addUser(UserRegister userRegister);

    UserRegister getById(Long id);

    UserRegister getByName(String name);

    List<UserRegister> getAllRegister();

}
