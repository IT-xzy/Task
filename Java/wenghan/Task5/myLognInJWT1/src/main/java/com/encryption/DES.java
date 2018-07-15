package com.encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 DES加密介绍
 DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现
 。
 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 */
public class DES {
    //无参构造方法
    public DES() {
    }
    //测试
    public static void main(String args[]) {
        //待加密内容
        String str = new Long(System.currentTimeMillis()).toString();
        //密码，长度要是8的倍数
        String password = "9588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456";

        byte[] result = DES.encrypt(str.getBytes(),password);
        System.out.println("加密后："+new String(result));
        //直接将如上内容解密

        byte[] decryResult = DES.decrypt(result, password);
        System.out.println("解密后："+new String(decryResult));
    }
    /**
     * 加密
     * @param datasource byte[]
     * @param password String
     * @return byte[]
     */
    //静态的加密方法（不需要构造对象），返回值为字节数组（保证是8位），形参：字节数组（数据源）、字符串（密码）
    public static  byte[] encrypt(byte[] datasource, String password) {
        //try捕获异常
        try{
            //SecureRandom:用于产生随机数的类
            SecureRandom random = new SecureRandom();

            //参考API：创建一个DES密钥.使用参数中的前8个字节作为DES密钥的内容
            DESKeySpec desKey = new DESKeySpec(password.getBytes());

            //创建一个DES的密匙工厂，返回指定算法的密码密钥的工厂对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");

            //调用DES的密钥工厂创建一个SecretKey对象
            SecretKey secretkey = keyFactory.generateSecret(desKey);

            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");

            //用密匙初始化Cipher对象（常数1,secretkey(形参相关),随机源）
            cipher.init(Cipher.ENCRYPT_MODE, secretkey, random);

            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(datasource);
        }catch(Throwable e){
            //如果报错，将异常输出
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 解密
     * @param src byte[]
     * @param password String
     * @return byte[]
     * @throws Exception
     */
    //静态方法，形参（字节数组，字符串（密码））
    public static byte[] decrypt(byte[] src, String password) {
        try{
        // DES算法要求有一个可信任的随机数源（同加密）
        SecureRandom random = new SecureRandom();

        // 创建一个DESKeySpec对象（同加密）
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        // 创建一个密匙工厂（同加密）
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象(同加密)
        SecretKey secretKey = keyFactory.generateSecret(desKey);

        // Cipher对象实际完成解密操作(同加密)
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象(同加密)
        cipher.init(Cipher.DECRYPT_MODE, secretKey, random);
            return cipher.doFinal(src);
        }catch(Throwable e){
            //如果报错，将异常输出
            e.printStackTrace();
        }
        // 真正开始解密操作(只有这一步跟加密方法不同)
        return null;
    }
}
