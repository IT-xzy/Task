package encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class DESTest {
//    public static void main(String[] args) {
//        //待加密内容
//        String str = "lin";
////密码，长度要是8的倍数
//        String password = "15264875";
//        byte[] result = DESTest.encrypt(str.getBytes(),password);
//        System.out.println("加密后内容为："+new String(result));
//
////直接将如上内容解密
//        try {
//            byte[] decryResult = DESTest.decrypt(result, password);
//            System.out.println("加密后内容为："+new String(decryResult));
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//    }
    //加密
    public  static byte[] encrypt(byte[] content,String key){
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey, random);
            return cipher.doFinal(content);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
    public  static byte[] decrypt(byte[] src, String password) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
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
