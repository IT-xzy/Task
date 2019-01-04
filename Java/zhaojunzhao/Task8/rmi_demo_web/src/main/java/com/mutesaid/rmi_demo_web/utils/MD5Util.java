package com.mutesaid.rmi_demo_web.utils;

import com.mutesaid.rmi_demo_core.model.Usr;
import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;

@Configuration
public class MD5Util {
    public static String encrypt(String str, String salt) {
        str += salt;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes());
            byte[] result = md5.digest();
            StringBuilder buf = new StringBuilder(result.length * 2);
            for (byte b : result) {
                buf.append(String.format("%02x", b & 0xff));
            }
            return buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean matchPwd(Usr usr, String inputString) {
        return usr.getPwd().equals(encrypt(inputString, usr.getUpdateAt().toString()));
    }

}
