package util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * MD5加密工具类
 */
public class Md5Util {
	public final static String getMd5(String str){
		MessageDigest mdInst = null;
		try {
			mdInst = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//使用指定的字节更新摘要
		mdInst.update(str.getBytes());
        //获得密文
		byte[] md = mdInst.digest();
		return StrConverUtil.byteArrToHexStr(md);
	}

	/**
	 * 使用Apache的Hex类实现Hex(16进制字符串和)和字节数组的互转
	 * @param str
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String md5Hex(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(str.getBytes());
			return new String(new Hex().encode(digest));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return "";
		}
	}

	public static String getSalt(){
		// 生成一个16位的随机数
		Random random = new Random();
		StringBuilder sBuilder = new StringBuilder(16);
		sBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));
		int len = sBuilder.length();
		if (len < 16) {
			for (int i = 0; i < 16 - len; i++) {
				sBuilder.append("0");
			}
		}
		// 生成最终的加密盐
		String salt = sBuilder.toString();
		return salt;
	}
	/**
	 * 加盐MD5
	 * @param password
	 * @return
	 */
	public static String getSaltMD5(String password,String salt) {
		password = md5Hex(password + salt);
		char[] cs = new char[48];
		for (int i = 0; i < 48; i += 3) {
			cs[i] = password.charAt(i / 3 * 2);
			char c = salt.charAt(i / 3);
			cs[i + 1] = c;
			cs[i + 2] = password.charAt(i / 3 * 2 + 1);
		}
		return String.valueOf(cs);
	}
}
