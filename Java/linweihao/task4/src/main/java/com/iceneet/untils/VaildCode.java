package com.iceneet.untils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class VaildCode {

    private static RedisTemplate redisTemplate;

    @Resource(name="redisTemplate")
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        VaildCode.redisTemplate = redisTemplate;
    }


    public static boolean vaild(String phone,String email,String code){
        String phoneCode = (String) redisTemplate.opsForValue().get(phone);
        String emailCode = (String) redisTemplate.opsForValue().get(email);
        System.out.println(phoneCode);
        System.out.println(emailCode);
        System.out.println(code);
        if (phoneCode!=null){
            return code.equals(phoneCode);
        }else if (emailCode!=null){
            return code.equals(emailCode);
        }else {
            return false;
        }
    }
}
