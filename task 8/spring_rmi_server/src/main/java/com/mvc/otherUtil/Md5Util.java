package com.mvc.otherUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
	private static Logger logger = LoggerFactory.getLogger(Md5Util.class);
	private static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	private static MessageDigest messagedigest = null;
	static {
		try {
			messagedigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			logger.error("MD5FileUtil messagedigest", e);
		}
	}

	public final static String getMultipartFileMd5(MultipartFile multipartFile){
		try {
			byte[] uploadBytes = multipartFile.getBytes();
			byte[] digest = messagedigest.digest(uploadBytes);
			String hashString = new BigInteger(1, digest).toString(16);
			return hashString;
		} catch (Exception e) {
			logger.debug("MD5获取失败");
		}
		return null;
	}

	public static String getFileMD5String(InputStream is) throws IOException {
		byte[] buffer = new byte[1024];
		int read = 0;
		while((read = is.read(buffer))>0){
			messagedigest.update(buffer,0,read);
		}
		return bufferToHex(messagedigest.digest());
	}

	private static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}

	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
		char c0 = hexDigits[(bt & 0xf0) >> 4];
		char c1 = hexDigits[bt & 0xf];
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}

	public static ByteArrayOutputStream getFile(InputStream inputStream)throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = inputStream.read(buffer)) > -1 ) {
			baos.write(buffer, 0, len);
		}
		baos.flush();
		return baos;
	}
}
