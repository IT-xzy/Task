package com.mutesaid.utils;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;

@Component
public class MD5Util {
    public static String encrypt(String str, String salt) {
        str += salt;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes());
            byte[] result = md5.digest();
            StringBuilder buf = new StringBuilder(result.length * 2);
            for (byte b : result) {
                buf.append(String.format("%02x", b & 0xff));
            }
            return buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
