package com.ptteng;

import org.junit.Test;

import javax.servlet.http.Cookie;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

public class CookieTest {
    @Test
    public void testCookie() throws NoSuchAlgorithmException {
        String name = "haha";
        String password = "1243";
        Cookie cookie = new Cookie(name, password);
        MessageDigest md5 = null;
        md5 = MessageDigest.getInstance("md5");
        byte[] cipherName = md5.digest(name.getBytes());
        String cipherNameStr = null;
        byte[] cipherPassword = md5.digest(password.getBytes());
        String cipherPasswordStr = null;

        System.out.println("cipherName"+cipherName);
        System.out.println("cipherPassword" + cipherPassword);
        for (int i=0;i<cipherName.length;i++){
            cipherNameStr += cipherName[i];
        }
        for (int i=0;i<cipherPassword.length;i++){
            cipherPasswordStr = cipherPasswordStr + cipherPassword[i];
        }
        System.out.println(cipherNameStr);
        System.out.println(cipherPasswordStr);
        StringBuilder builder=new StringBuilder();
        //haha  4e4d6c332b6fe62a63afe56171fd3725
        //1243  4e4d6c332b6fe62a63afe56171fd3725e1d5be1c7f2f456670de3d53c7b54f4a
        for (byte cipherN : cipherName){
            String toHexStr = Integer.toHexString(cipherN & 0xff);
            builder.append(toHexStr.length() == 1 ? "0" + toHexStr : toHexStr);
        }
        System.out.println(builder.toString());
        for (byte cipherP : cipherPassword){
            String toHexStr = Integer.toHexString(cipherP & 0xff);
            //4e4d6c332b6fe62a63afe56171fd3725e1d5be1c7f2f456670de3d53c7b54f4a
            builder.append(toHexStr.length() == 1 ? "0" + toHexStr : toHexStr);
        }
        System.out.println(builder.toString());
    }
    @Test
    public  void s() throws Exception{
        byte[] s="sftF/q1G2oc1Dc/ObyaZYQ==".getBytes();
        System.out.println(s.length);
    }
}
