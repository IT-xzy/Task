package com.iceneet.untils;

import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

/*
MD5加盐加密

 */
public class MD5Untils {

    public static String getStrMD5(String inStr) {
        // 获取MD5实例
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println(e.toString());
            return "";
        }

        // 将加密字符串转换为字符数组
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        // 开始加密
        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] digest = md5.digest(byteArray);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            int var = digest[i] & 0xff;
            if (var < 16)
                sb.append("0");
            sb.append(Integer.toHexString(var));
        }
        return sb.toString();
    }

//    public static String generate(String password) {
//        Random r = new Random();
//        StringBuilder sb = new StringBuilder(16);
//        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
//        int len = sb.length();
//        if (len < 16) {
//            for (int i = 0; i < 16 - len; i++) {
//                sb.append("0");
//            }
//        }
//        String salt = sb.toString();
//        password = md5Hex(password + salt);
//        char[] cs = new char[48];
//        for (int i = 0; i < 48; i += 3) {
//            cs[i] = password.charAt(i / 3 * 2);
//            char c = salt.charAt(i / 3);
//            cs[i + 1] = c;
//            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
//        }
//        return new String(cs);
//    }

    /**
     * 校验密码是否正确
     */
    public static boolean verify(String password, String md5,String salt) {
//        char[] cs1 = new char[32];
//        char[] cs2 = new char[16];
//        for (int i = 0; i < 48; i += 3) {
//            cs1[i / 3 * 2] = md5.charAt(i);
//            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
//            cs2[i / 3] = md5.charAt(i + 1);
//        }
//        String salt = new String(cs2);
        return getStrMD5(password + salt).equals(md5);
    }


    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }
    public static String generate(String pwd,String salt){
        return getStrMD5(pwd+salt);
    }

    public static String createUUID(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-","");
        return uuid;
    }


//    public static void main(String[] args) {
//        String salt = MD5Untils.createUUID();
//        System.out.println(salt);
//        System.out.println(MD5Untils.generate("java",salt));
//    }
}
