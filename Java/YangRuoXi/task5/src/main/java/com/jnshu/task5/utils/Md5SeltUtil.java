package com.jnshu.task5.utils;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Md5SeltUtil {
    //加密
    public static String md5Salt(String password){
        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder(16);
        //随机产生0-99999999的数字,并添加到sb中;
        sb.append(sr.nextInt(99999999)).append(sr.nextInt(99999999));

        int length = sb.length();
        //判断 如果小于0 用0来补充其他位
        if(length < 16) {
            for (int i = 0; i < 16 - length; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        // 将密码转换为字符数组;

        password = md5Hex(password + salt);
        //设置password和salt值
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String (cs);
    }

//使用MD5加密后转换为字符数组;
    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            //hex.encode()将字节数组转换为字节数组,用于按顺序表示每个字节的十六进制值的字符
            return new String (new Hex().encode(bs));
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    //解密
    public static boolean verify(String password ,String md5){
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }

//    public static void main(String[] args) {
//        String password = md5Salt("admin");
//        System.out.println("password : " + password + " ; length : " + password.length());
//        boolean password2 = verify("admin",password);
//        System.out.println("password是否相同 " + password2);
//    }

}
