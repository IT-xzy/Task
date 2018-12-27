package jnshu.util;
import org.junit.Test;

import javax.servlet.http.Cookie;

public class Token {

    public static Cookie getToken(String input,String salt)throws Exception{


        Long timeStamp = System.currentTimeMillis() / 1000;

        String date = ?;

        String key = "";

        String ciphertext=DES.desEncodeCBC(key,date);


        Cookie cookie = new Cookie("token",ciphertext);
        cookie.setMaxAge(3600*24*3);/

        return cookie;
    }
}
