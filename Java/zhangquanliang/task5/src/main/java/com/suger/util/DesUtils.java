package com.suger.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.SecureRandom;

/**
 * @author suger
 * @date 2018/11/25 23:59
 */
public class DesUtils {

    private static final String password = "9588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456";


    //测试
    public static void main(String args[]) {
        //待加密内容
        String str = "张泉良";

        String result = DesUtils.encode(str);
        System.out.println("加密后："+result);
        //直接将如上内容解密
        try {
            String decryResult = DesUtils.decode(result);
            System.out.println("解密后："+decryResult);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public DesUtils() {
    }


    /**
     * 加密
     * @param datasource byte[]
     * @param key byte[]
     * @return byte[]
     */
    public static  byte[] encrypt(byte[] datasource, byte[] key) {
        try{
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(key);
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(datasource);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 解密
     * @param src byte[]
     * @param key byte[]
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, byte[] key) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(key);
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

    private static String byte2hex(byte[] b) {
        String hs = "";
        String temp = "";
        for (int n = 0; n < b.length; n++) {
            temp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (temp.length() == 1)
                hs = hs + "0" + temp;
            else
                hs = hs + temp;
        }
        return hs.toUpperCase();

    }

    private static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("length not even");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

    private static String decode(String src, String key) {
        String decryptStr = "";
        try {
            byte[] decrypt = decrypt(hex2byte(src.getBytes()), key.getBytes());
            decryptStr = new String(decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptStr;
    }

    private static String encode(String src, String key){
        byte[] bytes = null;
        String encryptStr = "";
        try {
            bytes = encrypt(src.getBytes(), key.getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (bytes != null)
            encryptStr = byte2hex(bytes);
        return encryptStr;
    }

    /**
     * 解密
     */
    public static String decode(String src) {
        return decode(src, password);
    }

    /**
     * 加密
     */
    public static String encode(String src) {
        return encode(src, password);
    }
}
