package util;

import java.security.MessageDigest;
import java.util.Objects;
import java.util.Random;


/**
 * MD5加密工具类
 */
public class Md5Util {

    /**
     * 普通加密
     * 根据输入的字符串生成固定的32位MD5码
     */
    public static String createMd5(String info) {
        String strDes = "";
        try {
            //获得使用MD5加密算法的编码对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            //使用md5加密，生成byte数组，128位
            byte[] data = md.digest(info.getBytes("utf-8"));
            //将md5加密后的byte数组转成16进制的串
            StringBuilder sb = new StringBuilder();
            for (byte aData : data) {
                //高位补0，只保留低位，避免出现负数，所以这里要与0xff做与运算
                int n = aData & 0xff;
                //转成16进制串
                String hs = Integer.toHexString(n);
                //如果是1位，就补0，最多2位，因为0xff能表示到255，8位byte数组最多表示255
                if (hs.length() == 1) {
                    hs = "0" + hs;
                }
                sb.append(hs);
            }
            strDes = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDes;
    }

    /**
     * 加盐MD5
     *
     * @param password 密码
     * @return 加盐MD5
     */
    public static String createSaltMd5(String password) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            assert password != null;
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    /**
     * 校验加盐后是否和原文一致
     * @param password
     * @param saltMd5
     * @return boolean
     */
    public static boolean verifySaltMd5(String password, String saltMd5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = saltMd5.charAt(i);
            cs1[i / 3 * 2 + 1] = saltMd5.charAt(i + 2);
            cs2[i / 3] = saltMd5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return Objects.equals(md5Hex(password + salt), new String(cs1));
    }


    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return StrConvertUtil.byteArrToHexStr(bs);
        } catch (Exception e) {
            return null;
        }

    }
}
