package com.fgh.task2.Utils;

import java.nio.charset.Charset;

public class DesUtil {

    /**
     * 加密封装
     * @param srcStr
     * @param charset
     * @param skey
     * @return
     */
    public static String encrypt(String srcStr,Charset charset,String skey){
        byte[] src=srcStr.getBytes(charset);
        byte[] buf= Des.encrypt(src,skey);
        return Des.parseByte2HexStr(buf);
    }

    public static String decrypt(String hexStr, Charset charset, String sKey )
            throws Exception{
        byte[] src = Des.parseHexStrByte2(hexStr);
        byte[] buf = Des.decrypt(src, sKey);
        return new String(buf, charset);
    }
}
