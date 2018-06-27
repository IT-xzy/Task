package com.ev.service.implement;

import com.ev.DAO.UserDAO;
import com.ev.entity.User;
import com.ev.exception.WrongPasswordException;
import com.ev.manager.RedisCache;
import com.ev.service.UserService;
import com.ev.utils.MailUtil;
import com.ev.utils.OSSUtil;
import com.ev.utils.SMSUtil;
import com.ev.utils.UserTypeHandlerUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.security.SecureRandom;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private SMSUtil smsUtil;

    @Autowired
    private MailUtil mailUtil;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private OSSUtil ossUtil;

    @Override
    public User findUser(String str) throws Exception {
        String type = (new UserTypeHandlerUtil()).typeHandler(str);
        User user = new User();
        switch (type) {
            case "email":
                user = userDAO.findByEmail(str);
                break;
            case "phoneNumber":
                user = userDAO.findByPhoneNumber(str);
                break;
            case "username":
                user = userDAO.findByName(str);
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
        String salt = Arrays.toString(randomBytes);
        user.setSalt(salt);
//        将加密后的key存入
        String perkey = user.getPassword() + salt;
        user.setKeyValue(DigestUtils.sha512Hex(perkey));
        //默认邮箱未验证，状态为0，验证为1
        user.setStatus(0);
        //发送邮箱验证码,并在redis中以"email:code"的形式存储
        String mailCode = mailUtil.getMailCode(user);
        String mailBody = "http://www.elmvector.com/authMailCode?email="+user.getEmail()+"&code="+mailCode;
        mailUtil.sendMail(user.getEmail(), mailBody, "authenticate");
        redisCache.setString(user.getEmail(), mailCode, 30L);
        if (user.getAuthCode() == redisCache.getString(user.getPhoneNumber()))
            return userDAO.addUser(user);
        else
            return -1L;
    }

    @Override
    public boolean login(String account, String password) throws Exception {
        User user = findUser(account);
        String key = user.getKeyValue();
        String salt = user.getSalt();
        return key.equals(DigestUtils.sha512Hex(password + salt));
    }

    @Override
    public void getSmsCode(String phoneNumber) throws Exception {
        StringBuffer random = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            random = random.append((int) (Math.random() * 9));
        }
        String code = random.toString();
        redisCache.setString(phoneNumber, code, 30L);
        smsUtil.sendSms(phoneNumber, code);
    }

    public void setStatus(User user) throws Exception {
        userDAO.setStatus(user);
    }

    @Override
    public String uploadAvatar(MultipartFile file, String userName) throws Exception{
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String key = OSSUtil.getImgKey(userName, suffix);
        ossUtil.uploadFileToOSS(file,key);
        return ossUtil.getImgUrl(key);
    }



}
