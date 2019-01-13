package com.suger.util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * MD5加密解密及字符串对比工具类
 * @author suger
 * @date 2018/11/25 21:11
 */
public class MD5Utils {

    /**
     * 普通MD5
     * @param input
     * @return
     */

    public static String md5(String input) {
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

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    public static String generate(String password,String salt) {

        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i/3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String password = "zql";
        System.out.println("password = " + password);

        String salt = UUIDUtils.getUUID();
        System.out.println("salt = " + salt);
        System.out.println("MD5 1加盐："+md5(password+salt));

        System.out.println("MD5 1加盐 的长度:"+md5(password+salt).length());


        System.out.println("MD5 2加盐 :"+generate(password,salt));
        System.out.println("MD5 2加盐 的长度:"+generate(password,salt).length());
    }

}

