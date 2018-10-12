package com.lihoo.jnshu.common.util.encrypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * #Title: MD5Utils
 * #ProjectName task5_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/1-16:26
 */

@Component
@SuppressWarnings("unused")
public class MD5Utils {
    private static Logger logger = LoggerFactory.getLogger(MD5Utils.class);

    //    转十六进制
    public static String toHex(byte hash[]) {
        if (hash == null) {
            return null;
        }
        StringBuffer buffer = new StringBuffer(hash.length * 2);
        int i;

        for (i = 0; i < hash.length; i++) {
            if ((hash[i] & 0xff) < 0x10) {
                buffer.append("0");
            }
            buffer.append(Long.toString(hash[i] & 0xff, 16));
        }
        return buffer.toString();
    }

//    MD5加密
    public static String getPwdHash(String pwd,String salt){
        String hexString = null;
        String pwdSalt = salt + pwd;
        // 创建MD5对象
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // 计算散列值并以字节数组形式返回
            byte[] md5 = messageDigest.digest(pwdSalt.getBytes());
            // 将字节数组转换为十六进制字符串
            hexString = toHex(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("MD5对象创建失败");
        }
        return hexString;
    }




//    MD5
    private static byte[] md5(String s) {
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(s.getBytes("UTF-8"));
            byte[] messageDigest = algorithm.digest();
            return messageDigest;
        } catch (Exception e) {
            logger.error("MD5 Error...", e);
        }
        return null;
    }

//    哈希>16进制+MD5
    private static String hash(String s) {
        try {
            return new String(toHex(md5(s)).getBytes("UTF-8"), "UTF-8");
        } catch (Exception e) {
            logger.error("not supported charset...{}", e);
            return s;
        }
    }

    /**
     * 对密码按照用户名，密码，盐进行加密
     * @param username 用户名
     * @param password 密码
     * @param salt 盐
     * @return
     */
    public static String encryptUsernamePwd(String username, String password, String salt) {
        return MD5Utils.hash(username + password + salt);
    }

    /**
     * 对密码按照密码，盐进行加密
     * @param password 密码
     * @param salt 盐
     * @return
     */
    public static String encryptPwd(String password, String salt) {
        return MD5Utils.hash(password + salt);
    }

    public static void main(String[] args) {
//          单纯MD5加密
        String md5_OG = hash("111");

//          MD5加盐加密
        String md5_salt = encryptPwd("111", "111");

//          MD5加盐加密
        String md52 = encryptUsernamePwd("111","111", "111");

        logger.info(md5_OG);
        logger.info(md5_salt);
        logger.info(md52);
    }
}
