package com.example;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * @Author: Jaime
 * @Date: 2018/4/17 2:45
 * @Description: **/


    public class Des {
        public Des() {
        }

/**
         * 加密
         *
         * @param datasource byte[]
         * @param password   String
         * @return byte[]*/


        public static byte[] encrypt(byte[] datasource, String password) {
            try {
                SecureRandom random = new SecureRandom();
                //DESKeySpec指定一个 Des 密钥。使用其构造方法创建一个 DESKeySpec 对象，
                // 使用 key 中的前 8 个字节作为 Des 密钥的密钥内容。
                DESKeySpec desKey = new DESKeySpec(password.getBytes());
                //创建一个密匙工厂，然后用它把DESKeySpec转换成SecretKey对象
/*密钥工厂用来将密钥（类型 Key 的不透明加密密钥）
            转换为密钥规范（底层密钥材料的透明表示形式），
            反之亦然。秘密密钥工厂只对秘密（对称）密钥进行操作。*/

                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("Des");
                SecretKey securekey = keyFactory.generateSecret(desKey);
                //Cipher对象实际完成加密操作
/*
              返回实现指定转换的 Cipher 对象。
              此方法从首选 Provider 开始遍历已注册安全提供者列表。
              返回一个封装 CipherSpi 实现的新 Cipher 对象，该实现取
              自支持指定算法的第一个 Provider。
               参数：
               transformation - 转换的名称，例如 Des/CBC/PKCS5Padding。
*/

                Cipher cipher = Cipher.getInstance("Des");
 /*             用密匙初始化Cipher对象
              init(int opmode, Key key, SecureRandom random)
            opmode -此 Cipher 的操作模式（为以下之一：ENCRYPT_MODE、DECRYPT_MODE、WRAP_MODE 或 UNWRAP_MODE）
            key - 加密密钥
            random - 随机源*/


                cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
                //现在，获取数据并加密
                //正式执行加密操作
                return cipher.doFinal(datasource);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return null;
        }
/**
         * 加密
         *
         * @param src      byte[]
         * @param password String
         * @return byte[]*/


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
/**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return*/


    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

/**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return*/


    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
    }

