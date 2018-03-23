package com.ptteng.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    //加固定盐，值为"ptteng"
    //想要继续提高破解难度，可以采用随机盐（基于随机数）
    public final static String salt = "ptteng";

    public final static String getMd5(String str) {
        str += salt;
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //使用指定字节更新摘要
        messageDigest.update(str.getBytes());
        //获得密文
        byte[] md = messageDigest.digest();
        return byteArrToHexStr(md);
    }

    //可以自己改写这个方法，因为MD5加密是单向的，不需要解密
    private static String byteArrToHexStr(byte[] arrB) {
        int iLen = arrB.length;
        // 每个byte(8位)用两个(16进制)字符才能表示，所以字符串的长度是数组长度的两倍
        StringBuilder sb = new StringBuilder(iLen * 2);
        for (byte anArrB : arrB) {
            int intTmp = anArrB;
            while (intTmp < 0) {//把负数转化为正数
                intTmp = intTmp + 256;
            }
            if (intTmp < 16) {//小于0F的数需要在前面补0
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }

        return sb.toString();
    }

}
