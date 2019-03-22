package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.User;
import com.xiaobo.demo.util.DesUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("EmailCodeServiceImpl")
public class EmailCodeServiceImpl implements EmailCodeService{
    private static Logger log = Logger.getLogger(EmailCodeServiceImpl.class);

    @Autowired
    DesUtil desUtil;
    @Autowired
    UserService userService;
    @Autowired
    User user;
    @Override
    public String encryptActiveUrl(Integer userId){
        String toEncryptText = userId.toString()+"&"+String.valueOf(System.currentTimeMillis());
        System.out.println(toEncryptText);
        String link = "http://106.12.103.127:8001/a/emailActive?param=";
        try{
            String encryptedText = DesUtil.encrypt(toEncryptText);
            return link + encryptedText;
        }catch (Exception e){
            System.out.println(e);
            System.out.println(e.toString());
            return e.toString();
        }
    }
    @Override
    public Boolean decryptActiveUrl(String url){
        log.info("破解URL");
        try{
            String decryptedUrl = DesUtil.decrypt(url);
            String[] array = decryptedUrl.split("&");
            Integer userId = new Integer(array[0]);
            Long timestamp = new Long(array[1]);
            if(System.currentTimeMillis()-timestamp>86400000){
                return false;
            }
            User user = new User();
            user.setId(userId);
            user.setStatus(2);
            return userService.updateByPrimaryKeySelective(user);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e);
            return false;
        }

    }
}
