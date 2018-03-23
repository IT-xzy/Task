package com.ptteng.utils;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;

public class DesUtil {
    private static final String ENCRYPT_TYPE = "DES";
    //字符串默认值
    private static String defaultKey = "";
    //加密工具
    private Cipher encryptCipher = null;
    //解密工具
    private Cipher decryptCipher = null;

    public DesUtil() throws Exception{
        this(defaultKey);
    }


    //指定密钥构造方法
    public DesUtil(String strKey) throws Exception{
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        Key key = getKey(strKey.getBytes());
        encryptCipher = Cipher.getInstance(ENCRYPT_TYPE);
        encryptCipher.init(Cipher.ENCRYPT_MODE, key);
        decryptCipher = Cipher.getInstance(ENCRYPT_TYPE);
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
    }


    //加密字节数组
    private byte[] encryptStr(byte[] arr) throws Exception {
        return encryptCipher.doFinal(arr);
    }


    //加密字符串
    public String encrypt(String strIn) throws Exception {
        return byteArrToHexStr(encryptStr(strIn.getBytes()));
    }


    //解密字节数组
    private byte[] decryptStr(byte[] arr) throws Exception {
        return decryptCipher.doFinal(arr);
    }

     //解密字符串
    public String decrypt(String strIn) throws Exception {
        return new String(decryptStr(hexStrToByteArr(strIn)));
    }


    /*从指定字符串生成密钥，密钥所需的字节数组长度为8位。不足8位时后面补0，超出8位只取前8位*/
    private Key getKey(byte[] arrBTmp) {
        byte[] arrB = new byte[8];// 创建一个空的8位字节数组（默认值为0）
        // 将原始字节数组转换为8位
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        return new javax.crypto.spec.SecretKeySpec(arrB, ENCRYPT_TYPE);// 生成密钥
    }

    private String byteArrToHexStr(byte[] arrB){
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

    // 将表示16进制值的字符串转换为byte数组，和public static String byteArrToHexStr(byte[] arrB)
    private byte[] hexStrToByteArr(String strIn){
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;
        // 两个(16进制)字符表示一个字节(8位)，所以字节数组长度是字符串长度除以2
        byte[] arrOut =new byte[iLen/2];
        for (int i = 0; i < iLen; i = i+2){
            String strTmp = new String(arrB,i,2);
            arrOut[i/2] = (byte) Integer.parseInt(strTmp,16);
        }
        return arrOut;
    }

}

