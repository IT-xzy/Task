package com.tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MD5Util {
    //普通的md5加密
    public String md5encryption(String str) throws NoSuchAlgorithmException {
        // 生成一个MD5加密计算
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        // 返回加密后的密码
        return new BigInteger(1, messageDigest.digest(str.getBytes())).toString(16);
    }

    public String generatePassword(String password) throws NoSuchAlgorithmException {
        // 生成一个16位的随机数
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer(16);
        for (int i = 0; i < 16; i++) {
            stringBuffer.append(random.nextInt(10));
        }
        //生成加密的随机盐
        String salt = stringBuffer.toString();
//        System.out.println(salt);
        //生成加密加盐的password
        password = md5encryption(password + salt);
//        System.out.println(password);
        //把盐隔2插1绑定到password上，然后返回生成的组合密码体
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return String.valueOf(cs);
    }

    //检查输入的密码和数据库的密码是一致
    public boolean checkPassword(String inPutPassword, String dbPassword) throws NoSuchAlgorithmException {
        //从组合密码体中分离出盐cs2和密码cs1
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = dbPassword.charAt(i);
            cs1[i / 3 * 2 + 1] = dbPassword.charAt(i + 2);
            cs2[i / 3] = dbPassword.charAt(i + 1);
        }
        String salt = new String(cs2);
//        System.out.println(salt);
        //对新输入的密码进行加密加盐，然后跟分离出的密码cs1对比，判断密码是否正确
        return md5encryption(inPutPassword + salt).equals(String.valueOf(cs1));
    }

//    public static void main(String[] args) {
//        MD5Util md5Util = new MD5Util();
//        try {
//            String md5Password = md5Util.generatePassword("23345");
//            Boolean flag = md5Util.checkPassword("23345", md5Password);
//            System.out.println(md5Password);
//            System.out.println(flag);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//    }
}
