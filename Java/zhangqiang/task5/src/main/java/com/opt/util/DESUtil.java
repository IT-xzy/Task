package com.opt.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 *
 *  DES双向加密工具类
 */
public class DESUtil {
    //安全密钥
    private String keyData = "ABCDEFGHIJKLMNOPQRSTWXYZabcdefghijklmnopqrstwxyz0123456789-_.";

    //无参构造
    public DESUtil() {
    }

    //有参构造
    public DESUtil(String key) {
        this.keyData = key;
    }

    /**
     * 加密UTF-8，调用底下的方法
     * @param source 待加密数据
     * @return 加密完成的数据
     * @throws UnsupportedEncodingException
     * 异常
     */
    public String encrypt(String source)throws UnsupportedEncodingException {
        return encrypt(source, "UTF-8");
    }

    /**
     *解密UTF-8，调用底下的方法
     * @param encryptedData 待解密数据
     * @return 解密完成数据
     * @throws UnsupportedEncodingException
     * 异常
     */
    public String decrypt(String encryptedData) throws UnsupportedEncodingException {
        return decrypt(encryptedData, "UTF-8");
    }

    /**
     *功能：加密
     * @param source 待加密数据
     * @param charSet 字符编码
     * @return 加密完成数据
     * @throws UnsupportedEncodingException
     * 异常
     */
    public String encrypt(String source, String charSet)
            throws UnsupportedEncodingException {
        String encrypt = null;
        byte[] ret = encrypt(source.getBytes(charSet));
        encrypt = new String(Base64.encode(ret));
        return encrypt;
    }

    /**
     *功能：解密
     * @param encryptedData 待解密数据
     * @param charSet 字符编码
     * @return 解密完成数据
     * @throws UnsupportedEncodingException
     * 异常
     */
    public String decrypt(String encryptedData, String charSet)
            throws UnsupportedEncodingException {
        String decryptedData = null;
        byte[] ret = decrypt(Base64.decode(String.valueOf(encryptedData.toCharArray())));
        decryptedData = new String(ret, charSet);
        return decryptedData;
    }

    /**
     *
     * @param primaryData
     * @return
     */
    private byte[] encrypt(byte[] primaryData) {

//取得安全密钥
        byte rawKeyData[] = getKey();

//DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

//使用原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = null;
        try {
            dks = new DESKeySpec(keyData.getBytes());
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

//创建一个密钥工厂
        SecretKeyFactory keyFactory = null;
        try {
            keyFactory = SecretKeyFactory.getInstance("DES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

//用密钥工厂把DESKeySpec转换成一个SecretKey对象
        SecretKey key = null;
        try {
            key = keyFactory.generateSecret(dks);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

// Cipher对象实际完成加密操作
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("DES");
        } catch (NoSuchAlgorithmException|NoSuchPaddingException e) {
            e.printStackTrace();
        }

// 用密钥初始化Cipher对象
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key, sr);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

// 正式执行加密操作
        byte encryptedData[] = null;
        try {
            encryptedData = cipher.doFinal(primaryData);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException|BadPaddingException e) {
            e.printStackTrace();
        }

//返回加密数据
        return encryptedData;
    }

    /**
     *
     * @param encryptedData
     * @return
     */
    private byte[] decrypt(byte[] encryptedData) {

/** DES算法要求有一个可信任的随机数源 */
        SecureRandom sr = new SecureRandom();

/** 取得安全密钥 */
        byte rawKeyData[] = getKey();

/** 使用原始密钥数据创建DESKeySpec对象 */
        DESKeySpec dks = null;
        try {
            dks = new DESKeySpec(keyData.getBytes());
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

/** 创建一个密钥工厂 */
        SecretKeyFactory keyFactory = null;
        try {
            keyFactory = SecretKeyFactory.getInstance("DES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

/** 用密钥工厂把DESKeySpec转换成一个SecretKey对象 */
        SecretKey key = null;
        try {
            key = keyFactory.generateSecret(dks);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

/** Cipher对象实际完成加密操作 */
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("DES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }

/** 用密钥初始化Cipher对象 */
        try {
            cipher.init(Cipher.DECRYPT_MODE, key, sr);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

/** 正式执行解密操作 */
        byte decryptedData[] = null;
        try {
            decryptedData = cipher.doFinal(encryptedData);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        return decryptedData;
    }

    /**
     *
     * @return
     */
    private byte[] getKey() {

/** DES算法要求有一个可信任的随机数源 */
        SecureRandom sr = new SecureRandom();

/** 为我们选择的DES算法生成一个密钥生成器对象 */
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance("DES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        kg.init(sr);

/** 生成密钥工具类 */
        SecretKey key = kg.generateKey();

/** 生成密钥byte数组 */
        byte rawKeyData[] = key.getEncoded();

        return rawKeyData;
    }
}
