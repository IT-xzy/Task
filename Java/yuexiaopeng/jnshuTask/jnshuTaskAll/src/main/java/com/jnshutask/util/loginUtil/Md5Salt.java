package com.jnshutask.util.loginUtil;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;

/*
MD5加盐工具类
*/
@Component
public class Md5Salt {
    static Logger logger = LoggerFactory.getLogger(Md5Salt.class);

    //加密算法，传入待加密的字符，和盐值；
    public String encrypt(String string, String salt) {
        String stringEncrypt = null;
        //如果账号或密码为空，返回error；
        if (string != null && salt != null) {
            try {
                //声明使用md5加密
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                //得到初始的md5加密字符串
                byte b1[] = string.getBytes();
                byte b2[] = messageDigest.digest(b1);
                System.out.println(string.hashCode());
                System.out.println(string.toString());
                System.out.println(b1.hashCode());
                System.out.println(b1.toString());
                System.out.println(b2.hashCode());
                System.out.println(b2.toString());
                String string1 = new BigInteger(1, b2).toString(16);
                //进行md5加盐加密
                String stringFinal = string1 + salt;
                byte final1[] = stringFinal.getBytes();
                byte final2[] = messageDigest.digest(final1);
                String stringFinal2 = new BigInteger(1, final2).toString(16);
                stringEncrypt = stringFinal2;
            } catch (Exception e) {
                logger.error("md5加密出现错误。。" + e.getMessage());
                return stringEncrypt;
            }
            //返回加密后的值；
            return stringEncrypt;
        }
        //传入出现空值，直接返回null；
        return stringEncrypt;
    }

    //验证算法
    public Boolean decrypt(String stringPass, String salt, String stringEncrypt) {
        boolean booleanDecrypt = false;
        String stringDecrypt = null;
        //传入的值不为空，进行验证
        if (stringPass != null && salt != null && stringEncrypt != null) {
            try {
                //声明使用md5加密
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                //得到初始的md5加密字符串
                byte b1[] = stringPass.getBytes();
                byte b2[] = messageDigest.digest(b1);
                String string1 = new BigInteger(1, b2).toString(16);
                //进行md5加盐加密
                String stringFinal = string1 + salt;
                byte final1[] = stringFinal.getBytes();
                byte final2[] = messageDigest.digest(final1);
                String stringFinal2 = new BigInteger(1, final2).toString(16);
                stringDecrypt = stringFinal2;
                //进行加密后密码的判断
                if (stringDecrypt.equals(stringEncrypt)) {
                    booleanDecrypt = true;
                } else {
                    booleanDecrypt = false;
                }
            } catch (Exception e) {
//                e.printStackTrace();
                logger.error("md5验证出现错误。。" + e);
            }
            return booleanDecrypt;
        }
        //传入出现空值，返回false的boolean值；
        return booleanDecrypt;
    }

}
