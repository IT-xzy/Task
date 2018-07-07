package utils;


import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class Des {
    public static Key getKey() throws Exception{
        //生成key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] bytes = secretKey.getEncoded();
        //转换key
        DESKeySpec desKeySpec = new DESKeySpec(bytes);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        Key key = secretKeyFactory.generateSecret(desKeySpec);
        return key;
    }
//    //加密
//    public static byte[] createDes(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException, InvalidKeyException {
//        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
//        cipher.init(Cipher.ENCRYPT_MODE,key);
//        byte[] result = cipher.doFinal(str.getBytes());
//        return result;
//    }
//    //解密
//    public static void getDes(byte[] result) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, InvalidKeyException {
//        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
//        System.out.println(key);
//        cipher.init(Cipher.DECRYPT_MODE,key);
//        result = cipher.doFinal(result);
//        System.out.println(new String(result));
//    }

    //加密
    public static byte[] desEncrypt(byte[] plainText,String password) throws Exception{
        SecureRandom random = new SecureRandom();
        DESKeySpec desKeySpec = new DESKeySpec(password.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey,random);
        byte[] cipherText = cipher.doFinal(plainText);
        return cipherText;
    }
    //解密
    public static String desDecrypt(byte[] src,String password) throws Exception{
        SecureRandom random = new SecureRandom();
        DESKeySpec desKeySpec = new DESKeySpec(password.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(desKeySpec);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE,securekey,random);
        byte[] a = cipher.doFinal(src);
        String result = new String(a);
        return result;
    }

}
