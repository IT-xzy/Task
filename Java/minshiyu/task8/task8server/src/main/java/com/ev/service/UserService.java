package com.ev.service;

import com.ev.entity.User;
import com.ev.exception.WrongPasswordException;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    User findUser(String str) throws Exception;

    Long signUp(User user) throws Exception;

    boolean login(String account, String password) throws Exception;

    void getSmsCode(String phoneNumber) throws Exception;

    void setStatus(User user) throws Exception;

    String uploadAvatar(MultipartFile file, String userName) throws Exception;
}
