/*
import com.example.CharacterUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

*/
/**
 * @Author: Jaime
 * @Date: 2018/4/14 1:36
 * @Description: *
 *//*

*/
/**
 DES加密介绍
 DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现
 。
 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 *//*

public class DES {
    public DES() { }
    */
/**
     * 加密
     * @param datasource byte[]
     * @param password String
     * @return byte[]
     *//*

    public static  byte[] encrypt(byte[] datasource, String password) {
        try{
            SecureRandom random = new SecureRandom();
            //DESKeySpec指定一个 Des 密钥。使用其构造方法创建一个 DESKeySpec 对象，
            // 使用 key 中的前 8 个字节作为 Des 密钥的密钥内容。
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成SecretKey对象
            */
/*密钥工厂用来将密钥（类型 Key 的不透明加密密钥）
            转换为密钥规范（底层密钥材料的透明表示形式），
            反之亦然。秘密密钥工厂只对秘密（对称）密钥进行操作。*//*

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("Des");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            */
/*返回实现指定转换的 Cipher 对象。
              此方法从首选 Provider 开始遍历已注册安全提供者列表。
              返回一个封装 CipherSpi 实现的新 Cipher 对象，该实现取
              自支持指定算法的第一个 Provider。
               参数：
               transformation - 转换的名称，例如 Des/CBC/PKCS5Padding。*//*

            Cipher cipher = Cipher.getInstance("Des");
            //用密匙初始化Cipher对象
            */
/*init(int opmode, Key key, SecureRandom random)
            opmode -
            此 Cipher 的操作模式（为以下之一：ENCRYPT_MODE、DECRYPT_MODE、WRAP_MODE 或 UNWRAP_MODE）
            key - 加密密钥
            random - 随机源
             *//*

            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(datasource);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }
    */
/**
     * 加密
     * @param src byte[]
     * @param password String
     * @return byte[]
     *//*

    public static byte[] decrypt(byte[] src, String password) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("Des");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("Des");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }
    //测试
    public static void main(String args[]) {
        //待加密内容
        String str = "测试内容";
        //密码，长度要是8的倍数
        String password = "9588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456";
        byte[] result = DES.encrypt(str.getBytes(),password);
        System.out.println("加密后："+new String(result));
        System.out.println(password);
        //直接将如上内容解密
        try {
            byte[] decryResult = DES.decrypt(result, password);
            System.out.println("解密后："+new String(decryResult));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

*/
