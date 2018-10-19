package task05.util;

import task05.util.des.DesUtil;

import java.nio.charset.Charset;

public class DesUtilTest {
    private static final String SKEY = "abcdefgh";

    private static final Charset CHARSET = Charset.forName("gb2312");

    public static void main(String[] args) {

//      待加密内容
        String str = "测试内容,待加密";

        String  encryptResult = DesUtil.encrypt(str, CHARSET, SKEY);

        System.out.println(encryptResult);

//        将上面内容解密
        String decryResult = "";
        try {
            decryResult = DesUtil.decrypt(encryptResult, CHARSET, SKEY);
        }catch (Exception e1) {

            e1.printStackTrace();

        }
        System.out.println(decryResult);

    }

}