package com.alibaba;

import com.alibaba.util.DES;
import com.alibaba.util.MD5Util;

public class Test {
    public static void main(String[] args) {
        try {
            DES des = new DES("Java");// 自定义密钥
            String src = "韩要贺";
            String src1 = des.encrypt(src);
            String src2 = des.decrypt(src1);
            String src3 = MD5Util.MD5(src);
            System.out.println("DES加密前的字符：" + src + "，长度：" + src.length());
            System.out.println("DES加密后的字符：" + src1 + "，长度：" + src1.length());
            System.out.println("DES解密后的字符：" + src2 + "，长度：" + src2.length());
            System.out.println("MD5加密后的字符：" + src3 + "，长度：" + src3.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

