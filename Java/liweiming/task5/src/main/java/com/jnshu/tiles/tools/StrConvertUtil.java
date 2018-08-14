package com.jnshu.tiles.tools;

/**
 * @program: Tiles
 * @description: 字符串转换工具类
 * @author: Mr.Lee
 * @create: 2018-07-02 10:21
 **/
public class StrConvertUtil {

    
    /** 
    * @Description: 将byte数组转换为表示16进制值的字符串，如：byte[]{8,18}转换为：0813，和public static byte[]
    * @Param: [arrB] 需要转换的byte数组
    * @return: java.lang.String  转换后的字符串
    * @Author: Mr.Lee
    * @Date: 2018\7\2 0002 
    */ 
    public static String byteArrToHexStr(byte[] arrB) {
        int iLen = arrB.length;
        // 每个byte(8位)用两个(16进制)字符才能表示，所以字符串的长度是数组长度的两倍
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // 把负数转换为正数
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 小于0F的数需要在前面补0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }



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
