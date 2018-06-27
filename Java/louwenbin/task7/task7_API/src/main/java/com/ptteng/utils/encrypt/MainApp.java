package com.ptteng.utils.encrypt;


import java.nio.charset.Charset;

public class MainApp {
    private static final String  SKEY    = "12345678";
    private static final Charset CHARSET = Charset.forName("gb2312");

    public static void main(String[] args) {
        // 待加密内容
        String str = "测试内容，今天周四";
        String encryptResult = DesUtil.encrypt(str, CHARSET, SKEY);
        System.out.println(encryptResult);
        // 直接将如上内容解密
        String decryResult = "";
        try {
            decryResult = DesUtil.decrypt(encryptResult, CHARSET, SKEY);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        System.out.println(decryResult);
    }
}
