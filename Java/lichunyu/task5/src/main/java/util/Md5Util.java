package util;

import java.security.MessageDigest;


/**
 * MD5加密工具类
 */
public class Md5Util {
    /**
     * 根据输入的字符串生成固定的32位MD5码
     */
    public static String getMd5(String info) {
        String strDes = "";

        try {
            //获得使用MD5加密算法的编码对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            //使用md5加密，生成byte数组，128位
            byte[] data = md.digest(info.getBytes("utf-8"));

            //将md5加密后的byte数组转成16进制的串
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < data.length; i++) {
                //高位补0，只保留低位，避免出现负数，所以这里要与0xff做与运算
                int n = data[i] & 0xff;
                //转成16进制串
                String hs = Integer.toHexString(n);
                //如果是1位，就补0，最多2位，因为0xff能表示到255，8位byte数组最多表示255
                if (hs.length() == 1) {
                    hs = "0" + hs;
                }
                sb.append(hs);
            }
            strDes = sb.toString();
            //strDes = sb.substring(8,24);//16位，从0开始计算，取第8（包括）个到第24个（不包括）字符

        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDes;
    }
}
