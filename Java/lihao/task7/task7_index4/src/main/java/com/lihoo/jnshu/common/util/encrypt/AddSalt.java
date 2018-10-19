package com.lihoo.jnshu.common.util.encrypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static com.lihoo.jnshu.common.util.encrypt.MD5Utils.toHex;

/**
 * #Title: AddSalt
 * #ProjectName task5_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/3-18:35
 */


public class AddSalt {
    static Logger logger = LoggerFactory.getLogger(AddSalt.class);


    public static String getSalt() {
        SecureRandom secureRandom = null;
        try {
//        实例化一个伪随机数生成器
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.info("抱歉，没有这个算法");
        }
        // 定义一个长度为16字节的字节数组(即128位,跟MD5的散列值保持一致)
        // 为了安全,一般盐值长度要大于等于散列值函数输出值长度
        byte[] randomByteArray = new byte[16];
        // 生成指定的128位伪随机数并放入字节数组
        secureRandom.nextBytes(randomByteArray);
        // 将字节数组转换为十六进制字符串并返回
        return toHex(randomByteArray);
    }
}
