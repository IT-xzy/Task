package com.fgh.task2.Utils;

import java.nio.charset.Charset;

public class TokenUtil {
        private static final String KEY="1234asdf";
        private static final Charset CHARSET=Charset.forName("UTF-8");

    public static String generateToken(long id,long time){
        String s_id=String.valueOf(id);
        String s_time=String.valueOf(time);
        String token=s_id+"/"+s_time;
        String DesToken=DesUtil.encrypt(token,CHARSET,KEY);
        return  DesToken;
    }

    public static String decrypt(String token)throws Exception{
        String tokenData =DesUtil.decrypt(token,CHARSET,KEY);
        return tokenData;
    }


}
