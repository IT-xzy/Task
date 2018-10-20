package com.jns.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DESUtil {
    private byte[] desKey;

    // 字符串转化为十六进制字节数组
    public static byte[] converHexString(String ss) {
        byte digest[] = new byte[ss.length() / 2];
        for (int i = 0; i < digest.length; i++) {
            String byteString = ss.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte) byteValue;
        }
        return digest;
    }
    // 数组转字符串
    public static String toHexString(byte b[]){
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            String planinText = Integer.toHexString(0xff & b[i]);
            if (planinText.length() < 2){
                planinText = "0" + planinText;
            }
            hexString.append(planinText);
        }
        return hexString.toString();
    }

    // 解密数据
    public static String decrypt(String message, String key) throws Exception{
        byte[] byetsrc = converHexString(message);

        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        // key 必须是8字节长度
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(key.getBytes("UTF-8"));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

        byte[] retByte = cipher.doFinal(byetsrc);

        return new String(retByte);
    }

    // 加密数据
    public static byte[] encrypt(String message, String key) throws Exception{
        //Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        //创建一个密匙工厂，然后用它把DESKeySpec转换成
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(key.getBytes("UTF-8"));
        //用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

        return cipher.doFinal(message.getBytes("UTF-8"));
    }

}
