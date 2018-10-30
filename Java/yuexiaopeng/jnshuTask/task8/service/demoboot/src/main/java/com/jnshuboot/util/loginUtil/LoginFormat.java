package com.jnshuboot.util.loginUtil;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Slf4j
@Component
public class LoginFormat {
    /*
     * 验证账号和密码的格式方法
     * */
    public Boolean account(String loginAccount) {
        Boolean boo = false;
        //账号的限定，正则限定位数和字母及下划线，账户的匹配,字母开头，总位数8-15位；
        String regex = "^[A-Za-z]\\w{7,14}$";
        //判断账号的字符，字符是字母开头，并且只有字符数字下划线组成；
//        if(loginAccount!=null){
//            boo=Pattern.matches(regex,loginAccount);
//        }
        try {
            boo = Pattern.matches(regex, loginAccount);
        } catch (Exception e) {
            log.info("--通用账号格式异常--:" + e);
            return boo;
        }
        return boo;
    }

    /*
     * 密码格式的判断*/
    public Boolean password(String loginPassword) {
        Boolean boo = false;
        //密码的匹配，位数6-16位数字字符下滑线；
        String regex = "^\\w{6,16}$";
        //判断密码的字符，限制位数；
//        if(loginPassword!=null){
//            boo=Pattern.matches(regex,loginPassword);
//        }
        try {
            boo = Pattern.matches(regex, loginPassword);
        } catch (Exception e) {
            log.info("--账号密码格式异常--:" + e);
            return boo;
        }
        return boo;
    }

    /*
     * 手机号码格式的判断*/
    public Boolean mobile(String loginMobile) {
        Boolean boo = false;
        //手机号码的匹配，1位数字；
        String regex = "^[0-9]{11}$";
        //判断密码的字符，限制位数；
//        if(loginMobile!=null){
//            boo=Pattern.matches(regex,loginMobile);
//        }
        //更改为try形式的
        try {
            boo = Pattern.matches(regex, loginMobile);
        } catch (Exception e) {
            log.info("--手机账号格式异常--:" + e);
            return boo;
        }
        return boo;
    }

    /*
     * 邮箱格式的判断*/
    public Boolean mail(String loginMail) {
        Boolean boo = false;
        //验证邮箱格式；xxxxxxx@xx.xx.xx 第二个点及后的内容为缺省；
        String regex = "^\\w+@\\w+\\.\\w+(\\.?|\\w?)\\w+$";
        //判断密码的字符，限制位数；
//        if(loginMail!=null){
//            boo=Pattern.matches(regex,loginMail);
//        }
        try {
            boo = Pattern.matches(regex, loginMail);
        } catch (Exception e) {
            log.info("--邮箱账号格式异常--:" + e);
            return boo;
        }
        return boo;
    }
}
