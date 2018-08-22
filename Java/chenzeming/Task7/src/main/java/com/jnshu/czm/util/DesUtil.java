package com.jnshu.czm.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;



/**
 DES加密介绍
 DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现
 。
 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 */

public class DesUtil {

    //设置密钥
    private static final String KEY="885555547";


    //String 加密
    public static String encrypt(String data) throws Exception {
        byte[] bt = encrypt(data.getBytes());
        String strs = new BASE64Encoder().encode(bt);
        System.out.println("加密后："+strs);
        return strs;
    }

    //String 解密
    public static String decrypt(String data) throws IOException,
            Exception {
        if (data == null){
            return null;}
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf);
        System.out.println("解密后："+ new String(bt));
        return new String(bt);
    }



    /**
     * 加密过程
     * @param datasource byte[]
     * @return byte[]
     */
    public static byte[] encrypt(byte[] datasource) {
        try{
            SecureRandom random = new SecureRandom();
            //此类指定一个 DES 密钥
            DESKeySpec desKey = new DESKeySpec(KEY.getBytes());

            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");

            //根据提供的密钥规范生成 SecretKey 对象
            SecretKey securekey = keyFactory.generateSecret(desKey);

            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");

            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);

            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(datasource);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 解密
     * @param src byte[]
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src) throws Exception {

        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();

        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(KEY.getBytes());

        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");

        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");

        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);

        // 真正开始解密操作
        return cipher.doFinal(src);
    }
}



