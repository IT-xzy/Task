package com.leo.utils;

public class BytesOrHexString {
	
	// 将字节数组转换为十六进制字符串
	public static String bytesToHexString(byte[] bArr){
		// 若字节数组引用为空对象，则返回空对象
		if(bArr == null){
			return null;
		}
		
		// StringBuffer是可变类,线程安全
		StringBuffer stringBuffer = new StringBuffer(bArr.length);
		String sTmp;
		
		for (int i=0; i<bArr.length; i++){
			// 将byte转为int,在这里需要的是byte补码的无符号值,所以需要进行与位运算
			int v = 0xff & bArr[i];
			// 将每个字节(8位)转换为含两个字符的十六进制字符串
			sTmp = Integer.toHexString(v);
			// 当字节数值小于15时,即字节的高四位皆为0时,toHexString()方法会只使用低四位有效值而忽略高四位的0,从而导致
			// 生成只含一个字符的字符串,为了使生成数据保持一致(128位二进制散列值),需要进行如下判断并处理
			if(sTmp.length()<2){
				// 当生成只含一个字符的字符串时，在末尾追加0
				stringBuffer.append(0);
			}
			// 拼接生成的字符串
			stringBuffer.append(sTmp.toUpperCase());
		}
		// 返回String对象
		return stringBuffer.toString();
	}
	
	// 将十六进制字符串转换为字节数组
	public static byte[] hexStringToBytes(String hexString){
		// 若hexString指向null，则返回null（将此写在前面，可防止空指针异常）
		if (hexString == null){
			return null;
		}
		// 若hexString指向对象为空字符串，则返回空字节数组
		if (hexString.length() == 0){
			return new byte[0];
		}
		
		byte[] bArray = new byte[hexString.length() / 2];
		for (int i=0; i<bArray.length; i++){
			// 将十六进制字符串按每两个字符切割为一个个新子串
			String subString = hexString.substring(2*i, 2*i+2);
			// 将字符串参数作为有符号的十六进制整数进行解析 ,也可使用 bArray[i] = Integer.valueOf(subString,16).byteValue(); 二者等同,还有使用位运算的方法
			bArray[i] = (byte) Integer.parseInt(subString,16);
		}
		return bArray;
	}
}
