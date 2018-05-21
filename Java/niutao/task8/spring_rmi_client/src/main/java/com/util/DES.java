package com.util;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class DES {

    //加密
    public static byte[] encrypt(byte[] datasource, String password){
        try{
            //安全随机数
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            //创建一个密钥工厂，然后用它把DESKeySpec转换
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher= Cipher.getInstance("DES");
            //用密钥初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(datasource);

        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
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
    public static byte[] decrypt(byte[] src, String password) throws Exception {
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
