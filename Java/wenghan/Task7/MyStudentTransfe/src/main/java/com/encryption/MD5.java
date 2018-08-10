package com.encryption;

import java.security.MessageDigest;

public class MD5 {

    //将字节转换为16进制的字符串方法：
    //公共 静态 字符串   字节 To 16进制 字符串（形参是 字节数组）
    public static String bytesToHexString(byte[] src) {
            //字符串生成器  构造一个字符串生成器，并初始化为指定的字符串内容""
            StringBuilder stringBuilder = new StringBuilder("");
        //如果形参src是null 或者src字节数组中不存在数据
        if (src == null || src.length <= 0) {
            //返回null
            return null;
        }
        //遍历形参src数组
        for (int i = 0; i < src.length; i++) {
            //位与 oxFF：11 11 11 11 （单纯将字节转为int型）
            int v = src[i] & 0xFF;
            //转为十六进制的字符串表示
            String hv = Integer.toHexString(v);
            //如果字符串的长度小于2
            if (hv.length() < 2) {
                //将0的字符串表示形式追加到此序列。
                stringBuilder.append(0);
            }
            //将指定的字符串追加到此字符序列。
            stringBuilder.append(hv);
        }
        //将字符串生成器，生成的序列输出
        return stringBuilder.toString();
    }

    /**
     * 解析
     * @param hexString
     * @return
     */
    //将16进制的字符串转换为字节数组的方法
    //公有 静态 返回值字节数组  16进制的字符串 TO 字节 （形参：字符串:16进制字符串）
    public static byte[] hexStringToBytes(String hexString) {
        //如果形参为NULL 或 形参为" "
        if (hexString == null || hexString.equals("")) {
            //返回null
            return null;
        }
        //将所有字符转为大写
        hexString = hexString.toUpperCase();
        //字符串长度/2
        int length = hexString.length() / 2;
        //将字符串转为新的字符数组
        char[] hexChars = hexString.toCharArray();
        //设置字节数组长度
        byte[] d = new byte[length];
        //循环字节数组的长度
        for (int i = 0; i < length; i++) {
            //
            int pos = i * 2;
            //
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    /**
     * 将指定byte数组以16进制的形式打印到控制台
     * @param b
     */
    //公有 静态 无返回值 输出16进制字符串
    public static void printHexString(byte[] b) {
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            System.out.print(hex.toUpperCase());
        }

    }

    /**
     * Convert char to byte
     * @param c char
     * @return byte
     */
    //私有 静态 返回值 字节 字符转为字节（形参是字符）
    private static byte charToByte(char c) {
        //返回指定字符在此字符串中第一次出现处的索引。
        // 如果在此 String 对象表示的字符序列中出现值为 ch 的字符，则返回第一次出现该字符的索引
        return (byte) "0123456789abcdef".indexOf(c);
    }

    /**
     * 加密
     * @param str
     * @return
     */
    //公有 静态 字符串 编码 （形参是：字符串）
    public static String encode(String str) {
        //创建一个字符串保存" "：附初值
        String strDigest = "";
        try {
            // 此 MessageDigest 类为应用程序提供信息摘要算法的功能，必须用try,catch捕获
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            //创建字节数组 data
            byte[] data;
            //先将字符串转为字节，再调用MD5.digest()
            // 使用指定的 byte 数组对摘要进行最后更新，然后完成摘要计算
            data = md5.digest(str.getBytes("utf-8"));// 转换为MD5码
            //将完成摘要计算的字节数组转为字符串
            strDigest = bytesToHexString(data);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        //返回完成摘要计算的字符串
        return strDigest;
    }
}

