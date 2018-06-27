package com.mvc.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

public class DESUlit {
	private static final String PASSWORD_CRYPT_KEY = "779654316";// 示例密钥
	private final static String DES = "DES";
	public static void main(String[] args) {
		System.out.println(encrypt("liuhuan|1412521341", PASSWORD_CRYPT_KEY));
		System.out.println(decrypt("6BC06DE1417175728D0BD2320D0108FE94F6C28FAF2AF87D",PASSWORD_CRYPT_KEY));
	}
	/**
	 * 加密
	 * @param src 数据
	 * @param key 密钥，长度必须是8的倍数
	 * @return 返回加密后的数据
	 */
	private static byte[] encrypt1(byte[] src, byte[] key) throws Exception {
		SecureRandom sr = new SecureRandom();
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance(DES);
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
		return cipher.doFinal(src);
	}
	/**
	 * 解密
	 * @param src 数据
	 * @param key 密钥，长度必须是8的倍数
	 * @return 返回解密后的原始数据
	 */
	private static byte[] decrypt1(byte[] src, byte[] key) throws Exception {
		SecureRandom sr = new SecureRandom();
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance(DES);
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
		return cipher.doFinal(src);
	}
	/**
	 * 密码加密
	 */
	public final static String encrypt(String data, String key) {
		try {
			return byte2hex(encrypt1(data.getBytes(), key.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 密码解密
	 */
	public final static String decrypt(String data, String key) {
		try {
			return new String(decrypt1(hex2byte(data), key.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// 字节码转换成16进制字符串
	private static String byte2hex(byte bytes[]) {
		StringBuffer retString = new StringBuffer();
		for (int i = 0; i < bytes.length; ++i) {
			retString.append(Integer.toHexString(0x0100 + (bytes[i] & 0x00FF)).substring(1).toUpperCase());
		}
		return retString.toString();
	}
	// 将16进制字符串转换成字节码
	private static byte[] hex2byte(String hex) {
		byte[] bts = new byte[hex.length() / 2];
		for (int i = 0; i < bts.length; i++) {
			bts[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2),16);
		}
		return bts;
	}
}
