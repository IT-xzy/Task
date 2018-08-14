package com.utils;

/**
 * 字符串转换类
 */
public class StrConverUtil {
    /**
     * 将字节转换成16进制的字符串
     * @param arrByte 单个字符数组
     * @return 16进制的字符串
     */
    public static String byteArrToHexStr(byte[] arrByte){
        int iLen = arrByte.length;
        StringBuffer stringBuffer = new StringBuffer(iLen * 2);
        for (int i = 0; i <iLen ; i++) {
            int intTmp = arrByte[i];
            while (intTmp < 0) {// 把负数转换为正数
                intTmp = intTmp + 256;
            }
            if (intTmp < 16) {// 小于0F的数需要在前面补0
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toString(intTmp, 16));
        }
        return stringBuffer.toString();
    }

    /**
     * 将16进制转换字符串转换成字节数组
     * @param strIn
     * @return 单个字符的数组
     */
    public static byte[] hexStrToByteArr(String strIn) {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;
        // 两个(16进制)字符表示一个字节(8位)，所以字节数组长度是字符串长度除以2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }
}
