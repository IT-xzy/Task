package com.ev.service.implement;

import com.ev.dao.UserDAO;
import com.ev.entity.User;
import com.ev.service.UserService;
import com.ev.utils.UserTypeHandlerUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User findUser(String str) throws Exception {
        String type =(new UserTypeHandlerUtil()).typeHandler(str);
        User user=new User();
        switch (type) {
            case "email":
                user = userDAO.selectByEmail(str);
                break;
            case "phoneNumber":
                user = userDAO.selectByPhoneNumber(str);
                break;
            case "username":
                user = userDAO.selectByName(str);
                break;
        }
        return user;
    }

    @Override
    public Long signUp(User user) throws Exception {
        SecureRandom csprng = new SecureRandom();
        byte[] randomBytes = new byte[32];
        csprng.nextBytes(randomBytes);
//        将盐存入
        String salt=Arrays.toString(randomBytes);
        user.setSalt(salt);
//        将加密后的key存入
        String perkey=user.getPassword() + salt;
        user.setKeyValue(DigestUtils.sha512Hex(perkey));
        return userDAO.addUser(user);
    }

    @Override
    public boolean login(String account, String password) throws Exception {
        User user=findUser(account);
        String key = user.getKeyValue();
        String salt = user.getSalt();
        return key.equals(DigestUtils.sha512Hex(password + salt));
    }

}
