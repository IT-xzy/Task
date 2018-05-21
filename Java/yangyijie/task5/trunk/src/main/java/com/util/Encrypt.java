package com.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author Arike
 * Create_at 2018/1/8 11:10
 * 该类用于密码加密和验证的操作
 */

public class Encrypt {
    
    private Encrypt() { }
    
    /**
     * 将byte转为16进制
     * @param bytes 传入加密了过后的byte密码
     * @return 返回给加密方法操作的密码字符串
     */
    public static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(0Xff/*255*/ & aByte);//使用0Xff其实是使用1111 1111八个二进制位
            if(temp.length()==1){                      //但这里是作为int字面值来做的,所以他的二进制
                // 得到只有1位的时候在后面补0            应该为0000 0000 0000 0000 0000 0000 1111 1111
                stringBuffer.append("0");             //这样能保证byte为负数的时候去掉符号位.
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
    /**
     *
     * @return 返回一个盐值
     */
    public static String getSalt(){
        byte[] bytes =new byte[10];
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(bytes);
        return byte2Hex(bytes);
    }
    
    /**
     * 利用java原生的摘要实现SHA256加密
     * @param str 加密后的报文
     * @return 存储到服务器的密码
     */
    public static String getSHA256Str(String str){
        MessageDigest messageDigest;
        String encodeStr="";
        try {
            messageDigest= MessageDigest.getInstance("SHA-512");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr=byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }
}

