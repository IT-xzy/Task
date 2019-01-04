package com.mutesaid.service;

import com.mutesaid.pojo.Usr;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import java.io.IOException;

@Service
public interface UsrService {
    void insert(Usr usr, BindingResult error);

    Boolean hasUsrName(String name);

    Usr isTrue(String name, String pwd);

    void isTrueCode(String code, Usr usr);

    Boolean pwdMatch(String pwd, Usr usr);

    Cookie setToken(Usr usr);

    Integer phoneCode(String phone);

    Usr matchEmail(String token);

    void uploadPic(Cookie[] cookie, MultipartFile pic) throws IOException;

    String getPic(Cookie[] cookies);

    void sendEmail(Usr usr);
}
