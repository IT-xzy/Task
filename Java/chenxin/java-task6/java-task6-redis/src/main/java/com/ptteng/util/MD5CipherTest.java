package com.ptteng.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5CipherTest {
    public String cipherMethod(String string) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("md5");
        String cipherString = null;
        byte[] cipher= md5.digest(string.getBytes());

        for (int i=0 ;i<cipher.length;i++){
            cipherString += cipher[i];
        }
        StringBuilder builder = new StringBuilder();
        for (byte cipherS : cipher){
            String toHexStr = Integer.toHexString(cipherS & 0xff);
            builder.append(toHexStr.length() ==1 ? "0" + toHexStr : toHexStr);
        }
        String s= String.valueOf(builder);
        return s;
    }
}
