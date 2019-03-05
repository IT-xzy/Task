package com.jnshu.task5.utils;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    static Logger logger = LogManager.getLogger(Md5Util.class);

    public static String digest16(String inStr){
        return digest(inStr,16);
    }

    public static String digest(String inStr){
        return digest(inStr,32);
    }

    private static String digest(String inStr,int rang){
        // 首先判断字符串是否为空;
        MessageDigest md5 = null;
        if(StringUtil.isEmpty(inStr)){
            return "";
        }

        //不为空,进行加密;
        try {
            //获取messageDigest的信息
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.info("加密失败");
            return "";
        }
        // 新建一个字符串数组和字节数组;
        char [] charArray = inStr.toCharArray();
        //字节数组长度为字符数组长度
        byte[] byteArray = new byte[charArray.length];

        //循环字节数组,放到字节数组中;
        for (int i = 0; i < charArray.length; i++){
            byteArray[i] = (byte) charArray[i];
        }
        //调用加密算法进行加密
        byte[] md5Bytes = md5.digest(byteArray);

        //新建一个StringBuilder来存放字节数组
        StringBuilder hexValue = new StringBuilder();
        //将字节数组转换为16进制
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int)md5Bytes[i]) & 0xff;
            if (val < 16){
                //不足16位用0来补位
                hexValue.append("0");
            }
            //这个方法是将整数型装换为字符串以base16的方式;
            hexValue.append(Integer.toHexString(val));
        }
        if(rang == 32) {
            return hexValue.toString();
        } else {
            return hexValue.toString().substring(8,24);
        }
    }



//    public static void main(String arge[]) {
//        String s = new String("admin");
//        System.out.println(digest(s));
//    }

}
