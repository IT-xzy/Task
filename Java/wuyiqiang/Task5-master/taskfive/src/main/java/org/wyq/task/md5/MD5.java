package org.wyq.task.md5;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
    public static final String KEY_MD5 = "MD5";

    public static String getResult(String inputStr) {
        BigInteger bigInteger = null;
        //加盐
        inputStr = "######" + inputStr + "&&&&&&&&";
        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将当前 BigInteger 对象的数值转换为其等效字符串表示形式。
        return bigInteger.toString(16);
    }
}
