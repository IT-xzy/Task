package com.jnshu.tools;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @program: Tiles
 * @description: MD5加密工具
 * @author: Mr.Lee
 * @create: 2018-07-02 10:26
 **/

public class Md5Util {

    /**
     * @Description: 根据输入的字符串生成固定的32位MD5码
     * @Param: [str] 输入字符串
     * @return: java.lang.String MD5码
     * @Author: Mr.Lee
     * @Date: 2018\7\2 0002
     */
    public  static String getSaltMD5(String password) {

//        生成一个16位的随机数
        Random random = new Random();
        StringBuilder sBuilder = new StringBuilder(16);
        sBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));

        int len = sBuilder.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sBuilder.append("0");
            }
        }

//        生成最终的加密盐
        String salt = sBuilder.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[48];

        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return String.valueOf(cs);
    }

    /**
     * @Description: 使用Apache的Hex类实现Hex(16进制字符串和)和字节数组的互转
     * @Param: [str]
     * @return: java.lang.String
     * @Author: Mr.Lee
     * @Date: 2018\7\4 0004
     */
    @SuppressWarnings("unused")
    private static String md5Hex(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(str.getBytes());
            return new String(new Hex().encode(digest));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println(e.toString());
            return "";
        }
    }

    /**
    * @Description: 验证加盐后是否和原文一致
    * @Param: [password, md5str]
    * @return: boolean
    * @Author: Mr.Lee
    * @Date: 2018\7\4 0004
    */
    public static boolean getSaltverifyMD5(String password, String md5str) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5str.charAt(i);
            cs1[i / 3 * 2 + 1] = md5str.charAt(i + 2);
            cs2[i / 3] = md5str.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(String.valueOf(cs1));
    }


    public static void main(String[] args) {
        System.out.println("\t\t=======================================");
        // 原文
        String plaintext = "123456789";
        System.out.println("原始：" + plaintext);
        // 获取加盐后的MD5值
        String ciphertext = Md5Util.getSaltMD5(plaintext);
        System.out.println("加盐后MD5：" + ciphertext);
        System.out.println("是否是同一字符串:" + Md5Util.getSaltverifyMD5(plaintext, ciphertext));
    }

}