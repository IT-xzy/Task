package com.ssm.dao;

import com.ssm.model.UserRegister;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegisterMapper {
    int addUser(UserRegister userRegister);

    UserRegister getById(Long id);

    UserRegister getByName(String name);

    List<UserRegister> getAllRegister();
}
