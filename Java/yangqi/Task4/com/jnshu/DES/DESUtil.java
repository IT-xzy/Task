package com.jnshu.DES;

import java.nio.charset.Charset;

public class DESUtil {

    /**
     * 加密
     * @param srcStr
     * @param charset
     * @param sKey
     * @return
     */
    public static String encrypt(String srcStr, Charset charset, String sKey) {
        byte[] src = srcStr.getBytes(charset);
        byte[] buf = DES.encrypt(src, sKey);
        return DES.parseByte2HexStr(buf);
    }

    /**
     * 解密
     *
     * @param hexStr
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String decrypt(String hexStr, Charset charset, String sKey) throws Exception {
        byte[] src = DES.parseHexStr2Byte(hexStr);
        byte[] buf = DES.decrypt(src, sKey);
        return new String(buf, charset);
    }
}
