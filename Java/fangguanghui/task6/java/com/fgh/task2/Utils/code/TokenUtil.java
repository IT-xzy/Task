package com.fgh.task2.Utils.code;

import com.fgh.task2.Utils.code.DesUtil;

import java.nio.charset.Charset;

public class TokenUtil {
        private static final String KEY="1234asdf";
        private static final Charset CHARSET=Charset.forName("UTF-8");

    /**
     * 组装token
     * @param id
     * @param time
     * @return
     */
    public static String generateToken(long id,long time){
        //组装token
        String s_id=String.valueOf(id);
        String s_time=String.valueOf(time);
        String token=s_id+"/"+s_time;
        //加密
        String DesToken=DesUtil.encrypt(token,CHARSET,KEY);
        return  DesToken;
    }


    /**
     * 获取token中的id
     * @param token
     * @return
     * @throws Exception
     */
    public static int decrypt(String token)throws Exception{
        //token 解密
        String tokenData =DesUtil.decrypt(token,CHARSET,KEY);
        //获取id
        int id =Integer.parseInt( tokenData.split("/")[0]);
        return id;
    }


}
