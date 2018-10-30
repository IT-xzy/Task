package com.task5.until;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    //md5加密
    public  String md5encryption(String str) {
        try {
            // 生成一个MD5加密计算
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // 返回加密后的密码
            return new BigInteger(1, messageDigest.digest(str.getBytes())).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }return null;
        //出现异常返回null
    }
    //用随机数加盐
    public  String[] encryption(String string) {
        //随机数生成随机盐
        String salt = String.valueOf(5 * Math.random());
        //加密加盐
        String password = md5encryption(string + salt);
        //把加密后的密码和盐返回
        String[] ps = {password, salt};
        return ps;
    }
}
