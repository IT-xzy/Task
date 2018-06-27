package com.ptteng.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CipherDES {
    //要使用DES，先获取密钥，借助JDK自带的KeyGenerator
    public byte[] initKey() throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }

    //DES加密过程
    public byte[] encryptDES(byte[] key, byte[] date) throws Exception{
        SecretKey secretKey = new SecretKeySpec(key,"DES");
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[] resultBytes = cipher.doFinal(date);
        return  resultBytes;
    }


    public String bytesToHexString(byte[] bytes) throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        if (bytes ==null || bytes.length <=0) {
            return null;
        }
        for (int i=0;i<bytes.length;i++){
            int x=bytes[i] & 0xFF;
            String hv = Integer.toHexString(x);
            if (hv.length() <2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static String byteArrayToHexStr(byte[] byteArray) {
        if (byteArray == null){
            return null;
        }
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[byteArray.length * 2];
        for (int j = 0; j < byteArray.length; j++) {
            int v = byteArray[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static byte[] hexStrToByteArray(String str)
    {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        byte[] byteArray = new byte[str.length() / 2];
        for (int i = 0; i < byteArray.length; i++){
            String subStr = str.substring(2 * i, 2 * i + 2);
            byteArray[i] = ((byte)Integer.parseInt(subStr, 16));
        }
        return byteArray;
    }


    //解密过程
    public String decryptDES(byte[] key,byte[] data) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKey secretKey = new SecretKeySpec(key,"DES");
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] resultBytes = cipher.doFinal(data);
        return new String(resultBytes);
    }

    //获得加密字符串
    public String encryptString(String s,byte[] key ) throws Exception{
        String result=null;
        byte[] byteFromString=s.getBytes();
        byte[] bytes=encryptDES(key, byteFromString);
        result =bytesToHexString(bytes);
        return result;
    }

}
