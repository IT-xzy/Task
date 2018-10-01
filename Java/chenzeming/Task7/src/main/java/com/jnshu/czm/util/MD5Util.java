package com.jnshu.czm.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    /**
     * 普通MD5
     * @time 2018-7-27
     * @param input
     * @return
     */
    public static String MD5(String input) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return "check jdk";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        char[] charArray = input.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }


    /**
     * 普通MD5通过加盐用户名加密
     * @time 2018-7-27
     * @param password username
     * @return
     */

//    public static String setPasswordBySalt(String username, String password) {
//
//        //substring() 方法用于提取字符串中介于两个指定下标之间的字符。
//        String salt = username.substring(0, username.length() - 1);
//        String passwordToMd5 = MD5Util.MD5(password);
//        String finalPassword = MD5Util.MD5(passwordToMd5 + salt);
//        return finalPassword;
//    }

    public static String setPasswordBySalt(String password,String salt) {

        //substring() 方法用于提取字符串中介于两个指定下标之间的字符。
        String passwordToMd5 = MD5Util.MD5(password);
        String finalPassword = MD5Util.MD5(passwordToMd5 + salt);
        return finalPassword;
    }


}

