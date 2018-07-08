package com.ptt.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * @ClassName: DESUtil
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/28 19:32
 * @Version: 1.0
 */
@Component
public class DESUtil {

    private static String password;

    //注入配置文件中password的值，由于password是静态变量，所以只能用非静态的setter方法注入配置文件的属性。
    @Value("${password}")
    public void setPassword(String password) {
        DESUtil.password = password;
    }

    /**
     * @Description: 加密
     * @return: byte[]
     * @Date: 2018/5/28 22:48
     */
    public static String encrypt(String passwordGet) {
        try {
            //创建DESKeySpec对象
            DESKeySpec deskey = new DESKeySpec(password.getBytes("utf-8"));
            //创建秘钥工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            //用秘钥工厂将DESKeySpec对象转换为SecretKey对象
            SecretKey key = keyFactory.generateSecret(deskey);
            //创建Cipher对象
            Cipher cipher = Cipher.getInstance("DES");
            //使用秘钥初始化Cipher对象，SecureRandom可以为DES提供可信任随机数据源。
            cipher.init(Cipher.ENCRYPT_MODE, key, new SecureRandom());
            BASE64Encoder base64Encoder = new BASE64Encoder();
            //加密
            return base64Encoder.encode(cipher.doFinal(passwordGet.getBytes("utf-8")));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description: 解密
     * @return: byte[]
     * @Date: 2018/5/28 22:48
     */
    public static String decrypt(String passwordGet) {
        try {
            DESKeySpec desKey = new DESKeySpec((password.getBytes("utf-8")));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key, new SecureRandom());
            BASE64Encoder base64Encoder = new BASE64Encoder();
            return base64Encoder.encode(cipher.doFinal(passwordGet.getBytes("utf-8")));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}
