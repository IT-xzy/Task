package com.ssm.dao;

import com.ssm.model.UserEmailReg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEmailRegMapper {

    int addUserEmail(UserEmailReg userEmailReg);

    UserEmailReg getById(Long id);

    UserEmailReg getByName(String e_name);

    List<UserEmailReg> getAllEmailReg();
}
