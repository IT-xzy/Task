package jnshu.util;
import org.junit.Test;

import javax.servlet.http.Cookie;

public class Token {

    public static Cookie getToken(String input,String salt)throws Exception{


//        生成时间戳
        Long timeStamp = System.currentTimeMillis() / 1000;

//        拼装待加密数据
        String date = input+"/"+salt+"/"+timeStamp;

        String key = "qwerasdf";

//        加密
        String ciphertext=DES.desEncodeCBC(key,date);


        Cookie cookie = new Cookie("token",ciphertext);
        cookie.setMaxAge(3600*24*3);//设置其生命周期

        return cookie;
    }
}
