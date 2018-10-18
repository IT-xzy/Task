package com.task5.until;

import com.auth0.jwt.internal.org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

public class DES {
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }
    public String encrypt(String data){
        // 生成一个可信任的随机数源
        SecureRandom secureRandom = new SecureRandom();
        try {
            // 从原始密钥数据创建DESKeySpec对象
            DESKeySpec desKeySpec = new DESKeySpec(password.getBytes());
            //创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            //将DESKeySpec对象转换成SecretKey对象
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            //创建Cipher对象，Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, secureRandom);
            //正式执行加密操作
            byte[] result = cipher.doFinal(data.getBytes());
            //用Base64把byte[]转化为String
            return Base64.encodeBase64String(result);
        }
        catch (Throwable e) {
            return null;
        }
    }
    public String decrypt(String s) {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        try {
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey secretKey = keyFactory.generateSecret(desKey);
            // 创建Cipher对象，Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, secretKey, random);
            // 真正开始解密操作,用Base64把String转化为byte[]
            byte[] result = cipher.doFinal(Base64.decodeBase64(s));
            //返回byte[]对应的String
            return new String(result);
        } catch (Throwable e) {
            return null;
        }
    }
}
