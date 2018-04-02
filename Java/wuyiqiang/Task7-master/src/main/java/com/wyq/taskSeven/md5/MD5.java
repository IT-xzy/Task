package com.wyq.taskSeven.md5;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
    public static final String KEY_MD5 = "MD5";

    public static String getResult(String data) {
        BigInteger bigInteger = null;
        //加盐
        String inputStr = data + "#####";
        try {
            //实例化和初始化
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            //得到一个操作系统默认的字节编码格式的字节数组
            byte[] inputData = inputStr.getBytes();
            //按照MD5进行编码（准备，各就各位）
            md.update(inputData);
            //进行哈希计算（digest）,并转换数据类型
            bigInteger = new BigInteger(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将当前 BigInteger 对象的数值转换为其等效字符串表示形式。
        return bigInteger.toString(16);
    }
}
