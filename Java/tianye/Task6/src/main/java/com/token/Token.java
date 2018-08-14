package com.token;

import com.DES.DESUtil;

public class Token {
    //加密
    static DESUtil desUtil=new DESUtil();
    public static String encryptToken(String userId,long loginTime) throws Exception{
        String token = desUtil.encrypt(userId +"/" +loginTime);
        return token;
    }
    //解密
    public static String decryptToken(String token)throws Exception{
        String tokenSrcData=desUtil.decrypt(token);
        return tokenSrcData;
    }
}

