package com.jnshu.czm.util;

public class TokenUtil {

    /**
     * 生成Token并加密
     */
    public static String makeToken(String username)throws Exception{
        String s1 = username;
        String s2 = System.currentTimeMillis()+"";
        //每个字符串之间用逗号“,”隔开以便后面分割字符串
        String s3=""+s1+","+s2;
        //将用户名和登录时间进行加密
        String s4= DesUtil.encrypt(s3);
        return s4;
    }


}
