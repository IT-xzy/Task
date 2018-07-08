package com.mvc.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;

public class MD5Lock {
	static char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	private static final Integer SALT_LENGTH = 12;

	public static String md5lock(String a) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(a.getBytes());
/*		System.out.println("md5(abc)=" + byte2str(md5.digest()));
		md5.update("a".getBytes());
		md5.update("bc".getBytes());
		System.out.println("md5(abc)=" + byte2str(md5.digest()));*/
		return byte2str(md5.digest());
	}

	public static void main(String[] args)throws Exception {
		System.out.println("加密12334567: " + getEncryptedPwd("12334567"));
//		System.out.println(md5lock("1234"));
		String s = "1F1A5B4AB6A641CBAE0D241F58112B69F33E699B9D54009D7A70623B";
		byte[] salt = new byte[s.length()];
		salt = MD5Lock.hexStr2Bytes(s);
		System.out.println("jiemi :");
		for(int i=0;i<salt.length;i++){
			System.out.print(salt[i]);
		}
		System.out.println(validPassword("12334567","069D7206201245A5F956A4581AEBCB2728044CA930614AC8A13B8A12"));
	}

	public static String getEncryptedPwd(String a)
			throws Exception {
		//声明加密后的口令数组变量
		byte[] pwd = null;
		//随机数生成器
		SecureRandom random = new SecureRandom();

		//声明盐数组变量   12
		byte[] salt = new byte[SALT_LENGTH];
		//将随机数放入盐变量中
		random.nextBytes(salt);
		System.out.println("加密时的盐：");
		for(int i=0;i<12;i++){
			System.out.print(salt[i]);
		}

		//声明并创建消息摘要对象
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		//将盐数据传入消息摘要对象
		md5.update(salt);
		System.out.println("MD5加密时的盐：");
		for(int i=0;i<12;i++){
			System.out.print(salt[i]);
		}
		System.out.println();
		//将口令的数据传给消息摘要对象
		md5.update(a.getBytes());
		//获得消息摘要的字节数组
		byte[] digest = md5.digest();

		//因为要在口令的字节数组中存放盐，所以加上盐的字节长度
		pwd = new byte[digest.length + SALT_LENGTH];
		//将盐的字节拷贝到生成的加密口令字节数组的前12个字节，以便在验证口令时取出盐
		System.arraycopy(salt, 0, pwd, 0, SALT_LENGTH);
		//将消息摘要拷贝到加密口令字节数组从第13个字节开始的字节
		System.arraycopy(digest, 0, pwd, SALT_LENGTH, digest.length);
		System.out.println("加密后的pwd：");
		for(int i=0;i<pwd.length;i++){
			System.out.print(pwd[i]);
		}

		//将字节数组格式加密后的口令转化为16进制字符串格式的口令
		return byte2str(pwd);
	}

	public static String byte2str(byte []bytes){
		int len = bytes.length;
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < len; i++) {
			byte byte0 = bytes[i];
			result.append(hex[byte0 >>> 4 & 0xf]);
			result.append(hex[byte0 & 0xf]);
		}
		return result.toString();
	}

	public static String byteToHexString(byte[] b) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			hexString.append(hex.toUpperCase());
		}
		return hexString.toString();
	}

	public static byte[] hexStr2Bytes(String src){
		/*对输入值进行规范化整理*/
		src = src.trim().replace(" ", "").toUpperCase(Locale.US);
		//处理值初始化
		int m=0,n=0;
		int iLen=src.length()/2; //计算长度
		byte[] ret = new byte[iLen]; //分配存储空间

		for (int i = 0; i < iLen; i++){
			m=i*2+1;
			n=m+1;
			ret[i] = (byte)(Integer.decode("0x"+ src.substring(i*2, m) + src.substring(m,n)) & 0xFF);
		}
		return ret;
	}

	public static boolean validPassword(String password, String passwordInDb)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		//将16进制字符串格式口令转换成字节数组
		byte[] pwdInDb = hexStr2Bytes(passwordInDb);
		//声明盐变量
		byte[] salt = new byte[SALT_LENGTH];
		//将盐从数据库中保存的口令字节数组中提取出来
		System.arraycopy(pwdInDb, 0, salt, 0, SALT_LENGTH);
		System.out.println("解密盐：");
		for(int i=0;i<salt.length;i++){
			System.out.print(salt[i]);
		}
		//创建消息摘要对象
		MessageDigest md = MessageDigest.getInstance("MD5");
		//将盐数据传入消息摘要对象
		md.update(salt);
		//将口令的数据传给消息摘要对象
		md.update(password.getBytes());
		//生成输入口令的消息摘要
		byte[] digest = md.digest();
		//声明一个保存数据库中口令消息摘要的变量
		byte[] digestInDb = new byte[pwdInDb.length - SALT_LENGTH];
		//取得数据库中口令的消息摘要
		System.arraycopy(pwdInDb, SALT_LENGTH, digestInDb, 0, digestInDb.length);
		//比较根据输入口令生成的消息摘要和数据库中消息摘要是否相同
		if (Arrays.equals(digest, digestInDb)) {
			//口令正确返回口令匹配消息
			return true;
		} else {
			//口令不正确返回口令不匹配消息
			return false;
		}
	}
}