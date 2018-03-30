package com.wyq.taskSeven.verification;

import com.wyq.taskSeven.md5.MD5;
import com.wyq.taskSeven.util.AccountValidatorUtil;
import com.wyq.taskSeven.util.CCPRestSDKUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PhoneVerificationUtil {

    private static Logger logger = Logger.getLogger(PhoneVerification.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CCPRestSDKUtil ccpRestSDKUtil;

    private final static String verificationType = "1";
    private final static String verificationTime = "5";

    public boolean sendVerificationCode(PhoneVerification phoneVerification) {
//        六位数随机验证码
        String verificationCodeService = String.valueOf((int)((Math.random() * 9 + 1) * 100000));
//        将登陆信息放置到map中
        Map<String, String> map = pullMap(phoneVerification, verificationCodeService);
//        验证登陆信息格式，手机号位数等
        boolean flag = baseVerification(map);
        if (flag) {
//            调用荣联工具类，发送短信验证码
            String[] datas = new String[]{map.get("verificationCodeService"), verificationTime};
            flag = ccpRestSDKUtil.sendVerificationCode(map.get("phone"), verificationType, datas);
        }
        if (flag) {
//            将发送成功的验证信息存到redis
            map.remove("passwordAgain");
            String md5Password = MD5.getResult(map.get("password"));
            map.put("password", md5Password);
            redisTemplate.opsForHash().putAll(map.get("phone"), map);
//            Map<String, String> test = redisTemplate.opsForHash().entries(map.get("phone"));
//            System.out.println(test.get("phone"));
//            System.out.println(test.get("password"));
//            System.out.println(test.get("verificationCodeService"));
        }
        logger.info("验证码发送情况：" + flag + verificationCodeService);
        return flag;
    }

    private Map<String, String> pullMap(PhoneVerification phoneVerification, String verificationCodeService) {

        Map<String, String> map = new HashMap<String, String>();
        String phone = phoneVerification.getPhone();
        String password = phoneVerification.getPassword();
        String passwordAgain = phoneVerification.getPasswordAgain();

        map.put("phone", phone);
        map.put("password", password);
        map.put("passwordAgain", passwordAgain);
        map.put("verificationCodeService", verificationCodeService);
        return map;
    }

    private boolean baseVerification(Map<String, String> map) {
        boolean flag = true;
        if (!AccountValidatorUtil.isMobile(map.get("phone"))) {
            flag = false;
        }
        if (!AccountValidatorUtil.isPassword(map.get("password"))) {
            flag = false;
        }
        if (!(map.get("password").equals(map.get("passwordAgain")))) {
            flag = false;
        }
        return flag;
    }
}
