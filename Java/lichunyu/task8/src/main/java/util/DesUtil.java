package util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * DES加密工具类
 * Des 加密相关类介绍：
 * SecureRandom  这个类是继承自java.util.Random 这个类
 * SecureRandom 这个类的构造器有三种，下面例举两种：
 * SecureRandom()构造一个实现默认随机数算法的安全随机数生成器 (RNG)。
 * SecureRandom(byte[] seed)构造一个实现默认随机数算法的安全随机数生成器 (RNG)。
 *
 * DESKeySpec 这个类是用来使用原始秘钥来生成秘钥的秘钥内容
 * DESKeySpec 有两个构造函数：
 * DESKeySpec(byte[] key) 创建一个 DESKeySpec 对象，使用 key 中的前 8 个字节作为 DES 密钥的密钥内容。
 * DESKeySpec(byte[] key, int offset) 创建一个 DESKeySpec 对象，使用 key 中始于且包含 offset 的前 8 个字节作为 DES-EDE 密钥的密钥内容。
 * SecretKeyFactory ， 密钥工厂用来将密钥（类型 Key 的不透明加密密钥）转换为密钥规范（底层密钥材料的透明表示形式），反之亦然。秘密密钥工厂只对秘密（对称）密钥进行操作。
 *
 * SecretKey对象，秘钥对象，通过调用秘钥工厂的generateSecret（DESKeySpec deskeyspace） 方法来生成秘钥
 * Cipher 类为加密和解密提供密码功能，通过调用Cipher的getInstance("des") 来获取实例
 * Cipher 对象调用init（） 方法进行对象的初始化，init() 方法的具体参数按照具体情况而定，有加密的也有解密的常量
 * 最后调用Cipher的doFinal() 方法进行加密解密。
 */
public class DesUtil {

    private static final String DES = "DES";//DES加密方式
    private static final String SECRET_KEY ="loginout";//密钥,必须是8倍位字节,不能是中文
    public static String getKey() {
        return SECRET_KEY;
    }
    //private static final String utf8 = "utf-8";

    public DesUtil() {
        super();
    }

    /**
     * DES加密算法，对称加密
     * @param mode   模式： 加密，解密
     * @param data   需要加密的内容
     * @return     将内容加密后的结果也是byte[]格式的
     */
    private static byte[] des(int mode, byte[] data) {
        byte[] ret = null;
        byte[] keyData = getKey().getBytes();
        //加密的内容存在并且密钥存在且长度为8个字节
        if (data != null
                && data.length>0
                && keyData.length==8) {
            try {
                SecureRandom secureRandom = new SecureRandom(); //生成一个可信任的随机源
                Cipher cipher = Cipher.getInstance(DES); //获取加密实例
                DESKeySpec keySpec = new DESKeySpec(keyData); //使用keyData的前8位作为DES的密钥内容
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);  //密钥工厂将密钥转换成密钥规范
                SecretKey key = keyFactory.generateSecret(keySpec); //生成密钥对象
                cipher.init(mode, key,secureRandom);  //加密初始化，加解密模式mode，加密密钥key，可信任的随机源
                ret = cipher.doFinal(data);  //加解密内容
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException | InvalidKeySpecException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }


    //DES 加密
    public static String encrypt(String primaryData) {
        byte[] enByte = des(Cipher.ENCRYPT_MODE,primaryData.getBytes()); //加密
        return new BASE64Encoder().encode(enByte); //密文以Base64编码显示

    }
    //DES 解密
        public static String decrypt(String encryptData) throws IOException {
            byte[] deByte = new BASE64Decoder().decodeBuffer(encryptData); //对密文进行Base64解码后解密
            return new String(des(Cipher.DECRYPT_MODE,deByte));
    }
}
