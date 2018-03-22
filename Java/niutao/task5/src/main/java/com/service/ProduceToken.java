package com.service;

import com.util.DES;
import org.apache.commons.codec.binary.Base64;

public class ProduceToken {
    //密钥，长度要是8的倍数
    private static final String key = "aaaaaaaa";
    public static String getToken(String id,String logtime) {
        //生成token
        //待加密内容
        String str = id + logtime;
        byte[] result = DES.encrypt(str.getBytes(), key);
        String token = new String(Base64.encodeBase64(result));
        return token;
    }
}
