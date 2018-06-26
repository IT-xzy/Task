package hzw.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DESUtil {

    private byte[] desKey;

    // 字符串转化为十六进制字节数组
    public static byte[] converHexString(String ss){
        byte digest[] = new byte[ss.length() / 2];

        for (int i=0; i<digest.length; i++){
            String byteString = ss.substring(2*i,2*i+2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte)byteValue;
        }
        return digest;
    }

    // 数组转字符串
    public static String toHexString(byte b[]){
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            String planinText = Integer.toHexString(0xff & b[i]);
            if (planinText.length() < 2){
                planinText = "0" + planinText;
            }
            hexString.append(planinText);
        }
        return hexString.toString();
    }


    // 解密数据
    public static String decrypt(String message, String key) throws Exception{
        byte[] byetsrc = converHexString(message);

        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        // key 必须是8字节长度
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(key.getBytes("UTF-8"));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

        byte[] retByte = cipher.doFinal(byetsrc);

        return new String(retByte);
    }

    // 加密数据

    /**
     * Cipher：
     * Java/Android要使用任何加密，都需要使用Cipher这个类
     * 使用Cipher进行加密，解密处理，需要创建实例对象并初始化。采用工厂模式创建对象
     * Cipher cipher = Cipher.getInstance("算法名称");
     * cipher.init(加密/解密模式，Key秒);
     *
     * Key：
     * Key类是Java加密系统所有密码的父类
     *
     * SecretKeyFactory:
     * 对于DES加密解密，使用SecretKeyFactory生成，生成时需指定DESKeySpec
     *
     * DES加密,要求密码必须8个字节，64bit长度 byte[8]
     */
    public static byte[] encrypt(String message, String key) throws Exception{
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        //创建DESKeySpec类对象
        //参数为密钥，8个字节
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

        //转换成Key对象
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

        return cipher.doFinal(message.getBytes("UTF-8"));
    }

    public static void main(String[] args) throws Exception {
        String key = "liuhua";
        String value="testtesttest";
        String jiami=java.net.URLEncoder.encode(value, "utf-8").toLowerCase();

        System.out.println("加密数据:"+jiami);
        String a=toHexString(encrypt(jiami, key)).toUpperCase();


        System.out.println("加密后的数据为:"+a);

        String b=java.net.URLDecoder.decode(decrypt(a,key), "utf-8") ;
        System.out.println("解密后的数据:"+b);


    }
}
