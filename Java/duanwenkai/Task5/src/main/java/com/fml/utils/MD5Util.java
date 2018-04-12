package com.fml.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * MD5加密工具类
 */
public class MD5Util {

    public static String getMd5(String password){
        try {
            //获取一个指定算法的消息摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            /*
             *  执行加密，获取二进制密文。直接查编码表转化为字符串肯定乱码，
             *  因为byte数组无序混乱，编码表里面没有对应的组合。
             */
            byte[] md5 = md.digest(password.getBytes());
            /*
             *  Base64将每三个字节转化为四个字节，即每取6位前面补0，原来的8位从0到127就变成了
             *  现在的6位从0到63,总共64个数。Base64有自己的编码表，从0到63对应键盘上的一个字符，就不会出现乱码了
             */
            //BASE64Encoder encoder = new BASE64Encoder();
            return Base64.getEncoder().encodeToString(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMd5withSalt(String passwood, String salt){
        return getMd5(passwood+salt);
    }
}
