package com.jnshu.tools;

import org.junit.Test;



import static com.jnshu.tools.DESUtil.encrypt;


public class DESUtilTest {
    @Test
    public void DESUtiltest() throws Exception {
        String key = "liuhuan1";
        String value = 1 + "=" + System.currentTimeMillis();
        // java.net.URLEncoder.encode 中文字符转码
        String jiami = java.net.URLEncoder.encode(value, "utf-8").toLowerCase();

        System.out.println("加密数据:" + jiami);
        String a = DESUtil.toHexString(encrypt(jiami, key)).toUpperCase();

        System.out.println("加密后数据:" + a);

        String b = java.net.URLDecoder.decode(DESUtil.decrypt(a,key), "utf-8");
        System.out.println("解密数据: " + b);
    }
}
