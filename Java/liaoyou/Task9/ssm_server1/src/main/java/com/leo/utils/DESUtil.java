package com.leo.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class DESUtil {
	
	private final static Logger logger = LogManager.getLogger("mylog");
	// 此密钥固定
	private static final String hexDesKey = "1554643123AB5DA7";
	private static byte[] deskey = BytesOrHexString.hexStringToBytes(hexDesKey);
	
	// 加密方法
	public static String encrypt(String plaintext){
		// 将以字节数组形式存储的密钥还原为密钥对象(SecretKeySpec为对称密钥通用规范，当然也可以使用DESKeySpec和SecretKeyFactory来进行还原，只不过麻烦点)
		SecretKey secretKey = new SecretKeySpec(deskey,"DES");
		byte[] bytes = null;
		logger.debug("加密前明文："+plaintext);
		try {
			// 实例化用于加密的Cipher类对象，默认使用ECB/PKCS5Padding模式与填充方式
			Cipher cipher = Cipher.getInstance("DES");
			// 传入密钥、设置为加密模式进行初始化(此方法内部自动帮我们添加了一个随机数据源，当然我们也可以自己指定)
			cipher.init(Cipher.ENCRYPT_MODE,secretKey);
			// 生成字节数组形式的密文
			bytes = cipher.doFinal(plaintext.getBytes());
		} catch (NoSuchAlgorithmException e) {
			System.out.println("加密算法名称错误");
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			System.out.println("输入的加密密钥无效");
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		}
		logger.debug("加密成功，十六进制字符串密文："+BytesOrHexString.bytesToHexString(bytes));
		return BytesOrHexString.bytesToHexString(bytes);
	}
	
	// 解密方法
	public static String decrypt(String ciphertext){
		// 将以字节数组形式存储的密钥还原为密钥对象(SecretKeySpec为对称密钥通用规范，当然也可以使用DESKeySpec和SecretKeyFactory来进行还原，只不过麻烦点)
		SecretKey secretKey = new SecretKeySpec(deskey,"DES");
		String plaintext = null;
		logger.debug("解密前十六进制字符串密文："+ciphertext);
		
		try {
			// 实例化用于解密的Cipher类对象，默认使用ECB/PKCS5Padding模式与填充方式
			Cipher cipher = Cipher.getInstance("DES");
			try {
				// 传入密钥、设置为解密模式进行初始化
				cipher.init(Cipher.DECRYPT_MODE,secretKey);
				try {
					// 传入字节数组形式的密文进行解密，返回字节数组形式的明文
					byte[] bytesDate =cipher.doFinal(BytesOrHexString.hexStringToBytes(ciphertext));
					// 将字节数组形式的明文转为字符串
					plaintext = new String(bytesDate);
				} catch (IllegalBlockSizeException e) {
					logger.error("IllegalBlockSizeException");
				} catch (BadPaddingException e){
					logger.error("解密填充错误");
				}
			} catch (InvalidKeyException e) {
				System.out.println("输入的解密密钥无效或者缺少初始向量");
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println("解密算法名称错误");
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
		logger.debug("解密成功，解密后明文："+plaintext);
		return plaintext;
	}
}
