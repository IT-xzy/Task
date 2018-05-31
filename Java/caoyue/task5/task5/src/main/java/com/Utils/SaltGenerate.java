package com.Utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 生成盐
 * @create: 2018/5/8 下午2:49
 */

public class SaltGenerate {
    public static String getSalt() {
        
        Random ranGen = new SecureRandom();
        
        byte[] aesKey = new byte[10];
        
        ranGen.nextBytes(aesKey);
        
        return MessageDigestUtil.byteToString(aesKey);
        
    }
}
