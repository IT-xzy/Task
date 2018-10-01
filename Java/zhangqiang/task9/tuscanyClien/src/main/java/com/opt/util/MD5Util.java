package com.opt.util;


import org.apache.commons.codec.binary.Hex;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Logger;

/**
 * MD5加密
 *
 * @Title: 加密 MD5(Message Digest algorithm 5，信息摘要算法)
 * @Description: 通常我们不直接使用上述MD5加密。通常将MD5产生的字节数组交给BASE64再加密一把，得到相应的字符串
 * @author By.ZhangQiang
 * @date 2018-6-1
 *
 */
public class MD5Util {

    private static Logger logger = Logger.getLogger(MD5Util.class.getName());


    /**
     * MD5 普通加密
     * @param key
     * @return
     */
//    public static String MD5ForGeneral(String key){
//        char hexDigits[] = {
//                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' , 'G' , 'H'
//        };
//        byte[] btInput = key.getBytes();
//
//        try {
//            // 获得MD5摘要算法的 MessageDigest 对象
//            MessageDigest mdInst = MessageDigest.getInstance("MD5");
//
//            // 使用指定的字节更新摘要
//            mdInst.update(btInput);
//
//            // 获得密文
//            byte[] md = mdInst.digest();
//
//            // 把密文转换成十六进制的字符串形式
//            int j = md.length;
//
//            char str[] = new char[ j * 2];
//            int k = 0 ;
//            for(int i=0;i<j;i++){
//                byte byte0 = md[i];
//                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
//                str[k++] = hexDigits[byte0 & 0xf];
//            }
//            return new String(str);
//
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }


    /**
     * MD5 加盐方式
     * 生成32位md5码
     * @param pwd
     * @return
     */
//    public static String MD5ForPwd(String pwd){
//        try {
//
//            // 标准的md5加密后的结果
//            MessageDigest digest = MessageDigest.getInstance("MD5");
//
//            byte[] result = digest.digest(pwd.getBytes());
//
//            StringBuffer buffer = new StringBuffer();
//            buffer.delete(0,buffer.length());
//
//            // 把每一个byte 做一个与运算 0xff;
//            for(byte b:result){
//
//                // 与运算 加盐
//                int number = b & 0xff;
//                String str = Integer.toHexString(number);
//                if (str.length() == 1){
//                    buffer.append("0");
//                }
//                buffer.append(str);
//            }
//            // 标准的md5加密后的结果
//            return buffer.toString();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            return "";
//        }
//    }



    /**
     * 普通MD5
     * @author
     * @time
     * @param input
     * @return
     */
    public static String MD5(String input) {
        byte[] secretBytes;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(input.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code += "0";
        }
        return md5code;
    }

    /**
     * 加盐MD5
     * @author daniel
     * @time 2016-6-11 下午8:45:04
     * @param password
     * @return
     */
    public static  String MD5Y(String password){

//        获取随机加密
        Random r = new Random();
        StringBuffer buffer = new StringBuffer();
        buffer.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = buffer.length();
        if (len<16){
            for(int i=0;i<16 - len;i++){
                buffer.append("0");
            }
            logger.info("加密buffer："+buffer.toString());
        }

        String salt = buffer.toString();
        password = md5Hex(password + salt);
        char[] chars = new char[48];
        for(int i=0;i<48;i+=3){
            chars[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            chars[i + 1] = c;
            chars[i + 2] = password.charAt(i /3 * 2 +1);
        }
        return new String(chars);
    }

    /**
     * 校验加盐后是否和原文一致
     * @author daniel
     * @time 2016-6-11 下午8:45:39
     * @param password
     * @param md5
     * @return
     */
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

}
