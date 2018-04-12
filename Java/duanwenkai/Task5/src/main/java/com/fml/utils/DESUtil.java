package com.fml.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * DES加密解密工具类
 */
public class DESUtil {
    private static final String KEY = "qwe!@#$%";


    /**
     * 数据加密
     * @param data 需要加密的数据
     * @param key 密钥。密钥长度都必须是8的倍数
     * @return 加密后的数据
     */
    public static String encrypt(String data, String key){
        //生成一个可以信任的随机数
        SecureRandom secureRandom = new SecureRandom();
        try {
            //创建DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            //创建SecretKeyFactory秘钥工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            //把DESKeySpec转换成SecretKey对象；
            SecretKey secretKey = keyFactory.generateSecret(desKey);
            //加密模式
            Cipher cipher = Cipher.getInstance("DES");
            //初始化对象
            cipher.init(Cipher.ENCRYPT_MODE,secretKey,secureRandom);
            //加密
            byte[] bytes = cipher.doFinal(data.getBytes());
            //编码
            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密方法
     * @param data 需要解密的数据
     * @param key 密钥
     * @return 解密后的数据
     */

    public static String decrypt(String data, String key){
        //JDK1.8中对Base进行加密解密的做法（这里是解密）
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(data);


        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        try {
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey secretKey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, secretKey, random);
            // 真正开始解密操作
            return new String(cipher.doFinal(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 生成密钥
     * @return 返回生成的密钥
     */
    public static String getkey(){
        byte[] strBytes = KEY.getBytes();
        byte[] bytes = new byte[8];

        //超过8个字节，按8个字节算；不足8个字节，后面补0
        for (int i = 0; i < strBytes.length && i < bytes.length; i++){
            bytes[i] = strBytes[i];
        }
        return new String(bytes);
    }
}
