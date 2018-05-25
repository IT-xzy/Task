package com.task.utils;

import org.apache.commons.codec.binary.Hex;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * SHA256加密方法工具类
 * 获取随机盐
 */
public class EncryptionUtil {
    /**
     * 将传入的Str进行SHA256加密
     * @param str 传入的字符串
     * @return 加密完成获得的hashKey
     */
    public static String getSHA256Str(String str){
        MessageDigest messageDigest;
        String encdeStr="";
        try{
            messageDigest=MessageDigest.getInstance("SHA-256");
            byte[] hash=messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr= Hex.encodeHexString(hash);
        }catch (NoSuchAlgorithmException|UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return encdeStr;
    }

    /**
     * 使用安全随机数获取一个不乱码的随机盐
     * @return 获取的随机盐salt
     */
    public static String getNextSalt() {
        String str="";
        try {
            Random RANDOM = new SecureRandom();
            byte[] salt = new byte[16];
            RANDOM.nextBytes(salt);
          str = new String(salt, "UTF-8");
          //使得或许的盐不乱码
          str = new BASE64Encoder().encode(salt);
          }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return str;
    }
}
