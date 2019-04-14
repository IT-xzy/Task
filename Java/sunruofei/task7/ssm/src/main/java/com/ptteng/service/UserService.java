package com.ptteng.service;

import com.ptteng.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserService {
    boolean insert(User record);

    User selectByName(String name);

    User selectByCondition(@Param("name") String name, @Param("password") String password);

    User selectById(Long id);


    User selectCodePhone(@Param("code") String code ,@Param("phone") String phone);

    User selectCodeMail(@Param("mail") String mail ,@Param("code") String code);
    int insertMail(  @Param("name") String name ,@Param("password") String password
            , @Param("mail") String mail ,@Param("phone") String phone);
}
