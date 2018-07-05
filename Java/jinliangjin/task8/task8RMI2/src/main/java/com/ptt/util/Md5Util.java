package com.ptt.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * @ClassName: Md5Util
 * @Description: MD5加密
 * @Author: Jin
 * @CreateDate: 2018/5/30 15:21
 * @Version: 1.0
 */
public class Md5Util {
    public static String encrypt(String str){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            return base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
