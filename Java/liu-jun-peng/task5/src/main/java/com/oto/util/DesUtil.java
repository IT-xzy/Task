package com.oto.util;

import java.nio.charset.Charset;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/13 下午1:32
 */

public class DesUtil {

//    加密
     public static String encrypt(String srcStr, Charset charset, String sKey) {
           
           byte[] src = srcStr.getBytes(charset);
           byte[] buf = DES.encrypt(src, sKey);
           return DES.parseByte2HexStr(buf);
     }
     
//     解密
    public static String decrypt(String hexStr, Charset charset, String sKey) throws Exception {
        byte[] src = DES.parseHexStr2Byte(hexStr);
        byte[] buf = DES.decrypt(src, sKey);
        return new String(buf, charset);
    }
}
