package com.opt.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * 加密类
 *
 * @Title: 加密密码
 * @Description: SHA-256加密
 * @author By.ZhangQiang
 * @date 2018-6-1
 */
public class Sha256Util {

    private static Logger logger = Logger.getLogger(Sha256Util.class);
    /**
     * 信息摘要实例  SHA-256加密
     * @author Mr.Z
     * @time 2018-6-1 下午4:57:39
     * @param info
     * @return String
     */
    public static String getSha256(String info){

//        信息摘要
        MessageDigest messageDigest;
        String shaCodeAfter;

        try {

//            信息摘要实例 SHA-256
            messageDigest = MessageDigest.getInstance("SHA-256");
//            设置输入密文的输出格式
            messageDigest.update(info.getBytes("UTF-8"));

//            设置hash的Bytes格式
            byte[] hash = messageDigest.digest(info.getBytes("UTF-8"));


//            获取加密code
            shaCodeAfter = Hex.encodeHexString(hash);
            logger.info("\n加密info："+ info +"\nbytes:"+hash.toString()+ "\n加密后code："+shaCodeAfter);
            return shaCodeAfter;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "加密异常 {NoSuchAlgorithmException}";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "加密异常 {UnsupportedEncodingException}";
        }

    }
//    public static String getShaHash(String info){
//
//        String salt = getSalt();
//
//        String shaHash = getSha256(info+salt);
//
//        for(int i=0;i<64;i++){
//
//        }
//
//        logger.info("\n盐:" + salt);
//        return shaHash;
//    }
    /**
     * 获取盐 随机Byte[]
     * @author Mr.Z
     * @time 2018-6-1 下午4:57:39
     * @param
     * @return String
     */
    public static String getSalt(){

        Random r = new Random();
        StringBuffer buffer = new StringBuffer();
        buffer.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = buffer.length();
        if (len<16){
            for(int i=0;i<16 - len;i++){
                buffer.append("0");
            }
        }
        byte[] sa = new byte[16];
        r.nextBytes(sa);

        String salt = null;

        try {

            salt = new String(sa,"UTF-8");
            salt = new BASE64Encoder().encode(sa);
            //          salt = buffer.toString();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return salt;
    }



}
