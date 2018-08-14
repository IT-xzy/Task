package com.service;

import com.aliyuncs.exceptions.ClientException;
import com.exception.MyException;
import com.pojo.User;
import io.jsonwebtoken.Claims;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface UserDaoService {
    boolean login(User user) throws MyException, NoSuchAlgorithmException;

    boolean register(User user) throws MyException, NoSuchAlgorithmException;

    boolean update(User user) throws MyException;

    User getUser(String username) throws MyException;

    String sendPhoneCheckCode(String phoneNumber) throws ClientException;

    String sendMailCheckCode(String mailAddress) throws IOException;

}
