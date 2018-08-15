package com.jnshu.util;

import org.apache.commons.codec.binary.Base64;

public class TokenUtil {

    //生命密码
    private static String key = "qwer1234";

    public static String genToken(long id, long time) throws Exception {
        String s_id = String.valueOf(id);
        String s_time = String.valueOf(time);
        String tokenData = s_id + "/" + s_time;
        byte[] bytes = tokenData.getBytes();
        byte[] token = DesUtil.encrypt(bytes, key);
        String result = Base64.encodeBase64String(token);
        return result;
    }

    //解密
    public static String enToken(String token) throws Exception {

        byte[] bytes = Base64.decodeBase64(token.getBytes());
        byte[] tokenData = DesUtil.decrypt(bytes, key);
        return new String(tokenData);
    }
}
