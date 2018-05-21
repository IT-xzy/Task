package com.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 自带的加密类MessageDigest类（MD5或SHA加密）
 * @create: 2018/5/8 下午2:44
 */

public class MessageDigestUtil {
    public static String SHA256(String message){
        MessageDigest md = null;
        String outStr = null;
        
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(message.getBytes());
            
            outStr = byteToString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return outStr;
    }
    
    public static String byteToString(byte[] digest) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            System.out.println(digest[i]);
            String tempStr = Integer.toHexString(digest[i] & 0xff);
            if (tempStr.length() == 1) {
                buf.append("0").append(tempStr);
            } else {
                buf.append(tempStr);
            }
        }
        return buf.toString().toLowerCase();
    }
}
