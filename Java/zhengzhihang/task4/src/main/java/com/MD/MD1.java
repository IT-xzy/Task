package com.MD;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD1 {
    private  static  final  String KEY=":cookie@mycookie.com";

    //MD1 加密算法
    public static String calcMD1(String ss){
        String s=ss==null ? "" : ss;//若为null，返回空
        char hexDigits[] = {'0','1', '2', '3', '4', '1', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };//字典
        try {
            byte[] strTep = s.getBytes(); //获取字节 (入参)
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");//获取MD1
            mdTemp.update(strTep);//更新数据
            byte[] md=mdTemp.digest(); //加密
            int j=md.length; //加密后的长度
            char str[] = new char[j * 2];//新字符串
            int k=0;//计数器K
            for (int i =0 ; i < j; i++){
                byte byte0=md[i];
                str[k++] = hexDigits[byte0 >>> 4& 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new  String(str);
        } catch (Exception e) {
            return  null;
        }
    }
}
