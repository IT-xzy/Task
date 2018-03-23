package org.wyq.task.des;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Locale;

public class DES {

    ////    public static SecureRandom random = new SecureRandom();
//    /*
//     * 加密
//     */
//    public static byte[] encrypt(byte[] datasource) {
//        try {
//            SecureRandom random = new SecureRandom();
//            DESKeySpec desKey = new DESKeySpec(KEY.getBytes());
////            System.out.println(Arrays.toString(desKey.getKey()));
//            //创建一个密匙工厂，然后用它把DESKeySpec转换成
//            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
//            SecretKey securekey = keyFactory.generateSecret(desKey);
//            //Cipher对象实际完成加密操作
//            Cipher cipher = Cipher.getInstance("DES");
//            //用密匙初始化Cipher对象
//            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
//            //现在，获取数据并加密
//            //正式执行加密操作
//            return cipher.doFinal(datasource);
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /*
//     * 解密
//     */
//    public static byte[] decrypt(byte[] src) {
//        try {
//            // DES算法要求有一个可信任的随机数源
//            SecureRandom random = new SecureRandom();
//            // 创建一个DESKeySpec对象
//            DESKeySpec desKey = new DESKeySpec(KEY.getBytes());
////            System.out.println(Arrays.toString(desKey.getKey()));
//            // 创建一个密匙工厂
//            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
//            // 将DESKeySpec对象转换成SecretKey对象
//            SecretKey securekey = keyFactory.generateSecret(desKey);
//            // Cipher对象实际完成解密操作
//            Cipher cipher = Cipher.getInstance("DES");
//            // 用密匙初始化Cipher对象
//            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
//            // 真正开始解密操作
//            return cipher.doFinal(src);
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public static String KEY = "1234567812345678";
    public static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";

    public static String encode(String data) {
        if (data == null)
            return null;
        try {
            DESKeySpec dks = new DESKeySpec(KEY.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
            byte[] bytes = cipher.doFinal(data.getBytes());
            return byte2String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }

    public static String decode(String data) {
        if (data == null)
            return null;

        try {
            DESKeySpec dks = new DESKeySpec(KEY.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);
            return new String(cipher.doFinal(byte2hex(data.getBytes())));
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }

    }

    private static String byte2String(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toUpperCase(Locale.CHINA);
    }

    private static byte[] byte2hex(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException();
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }
}
