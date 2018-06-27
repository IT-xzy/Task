package com.ptteng.util;

import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;

@Component
public class DESAlgorithm {

//    /**
//     * 1算法的独立性和可靠性
//     *2实现独立性和相互作用性。
//     *算法的独立性是通过定义密码服类来获得，用户只需了解密码算法的概念，而不用去关系如何实现这些概念。
//     *实现的独立性和互相作用性通过密码服务提供器来实现。密码服务提供器是实现一个或多个密码服务的一个或多个程序包。
//     *软件开发商根据一定接口，将各种算法实现号，打包成一个提供器，用户可以安装不同的服务器。
//     *
//     * DES算法及如何利用DES算法加密和解密类文件的步骤：
//     *DES算法的入口参数有三个：Key，Date、Mode。其中Key为8个字节共64位，是DES算法的工作密钥；Date也为8个字节64位，是需要被加密或被解密的数据；Mode位DES的工作方式，有两种：加密或解密。
//     *  /
    private final static String DES ="DES";
    public static void main(String[] args) throws Exception{
        String data =  "123 456";
        String key = "wang!@#$%";
//        System.err.println(encrypt(data,key));
//       System.err.println(decrypt(encrypt(data,key),key));
    }
    /**
     * Description 根据键值进行加密
     * @param data
     * @param key 加密健byte数组
     * @return
     * @throw Exception
     */
    public  String encrypt(String data,String key) throws Exception{
        byte[] bt= encrypt(data.getBytes(),key.getBytes());
        String strs= new BASE64Encoder().encode(bt);
        return strs;
    }
    /**
     * Description 根据键值进行解密
     * @param data
     * @param key 加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public String decrypt(String data,String key) throws IOException,Exception {
        if (data == null) {
            return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf,key.getBytes() );
        return  new String(bt);
    }
    private byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }


    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }
}