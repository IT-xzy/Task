package com.jnshu.myutils;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class PasswordUtil {


    //输入字符串，输出32进制字符串形式的MD5摘要
    public static String MD5(String input) {
        /*MessageDigest 类为应用程序提供信息摘要算法的功能，
        如 MD5 或 SHA 算法。信息摘要是安全的单向哈希函数，
        它接收任意大小的数据，并输出固定长度的哈希值。*/
        MessageDigest md5 = null;
        try {
        //         获取类实例
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return "check jdk";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        // input.toCharArray是将字符串对象中的字符转化为字符串数组
        char[] charArray = input.toCharArray();
        //创建一个和字符串长度相同的字节数组
        byte[] byteArray = new byte[charArray.length];
        //将字符串数组转化为字节数组
        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        //获取摘要信息的字节数组
        byte[] md5Bytes = md5.digest(byteArray);
        /*StringBuffer类中的方法主要偏重于对于字符串的变化，
        例如追加、插入和删除等，这个也是StringBuffer和String类的主要区别*/
        StringBuffer hexValue = new StringBuffer();
        //遍历摘要信息字节数组的每个元素
        for (int i = 0; i < md5Bytes.length; i++) {
        //byte类型向高24位（就是int的32位）转换，直接转换会将高24位也看做是有效位数，
            // 会导致错误。将高24位置0就可以避免
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static String generate(String password) {
        //创建一个随机数生成器,没有随机种子时，以当前时间为随机种子;r.nextInt()产生随机数并设置随机数范围
        Random r = new Random();
        //  StringBuilder用字符串连接，可设置容量
        StringBuilder sb = new StringBuilder(16);
        //        产生随机数
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));

        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        //      获取16进制的密码加盐的摘要
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    //校验加盐后是否与原文一致，
    public static boolean verify(String password, String md5) {
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

}
