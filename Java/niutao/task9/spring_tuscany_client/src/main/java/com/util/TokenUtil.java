package com.util;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


public class TokenUtil {

    public static final Logger logger = (Logger) LoggerFactory.getLogger(TokenUtil.class);
    //密钥，长度要是8的倍数
    private static final String KEY = "aaaaaaaa";
    //组成

    private static String ProduceToken(String id, String logtime) {
        //待加密内容
        String str = id + logtime;
        byte[] result = DES.encrypt(str.getBytes(), KEY);
        String token = new String(Base64.encodeBase64(result));
        return token;
    }

    public static boolean VerifyToken(HttpServletRequest httpServletRequest) {
        String id = getTokenElementFromCookie(httpServletRequest,"id");
        String logtime = getTokenElementFromCookie(httpServletRequest,"logtime");
        String token = getTokenElementFromCookie(httpServletRequest,"token");
        //使用DES加密id和logtime字段，然后和token字段对比。
        //生成token
        String newtoken = ProduceToken(id, logtime);
        //如果相同，说明cookie有效
        return newtoken.equals(token);
    }

    private static String getTokenElementFromCookie(HttpServletRequest httpServletRequest, String cookieName) {
        return CookieUtil.getValueByName(httpServletRequest,cookieName);
    }

}
