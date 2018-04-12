package com.fml.utils;

/**
 *  此类为练习之作：
 *  用作将生成的密钥转化成16进制的字符串，和将16进制的字符串还原为密钥
 */
public class StrConvertUtil {

    /**
     * 将字节数组转化为16进制字符串
     * @param bytes
     * @return
     */
    public static String byteArrToHexStr(byte[] bytes){
        //二进制中一个字节（byte）八位，2的8次方为256
        //16进制中一个字符为16,16的平方256
        //所以，一个字节转化为两个字符
        int byteLen = bytes.length;
        StringBuffer sb = new StringBuffer(byteLen * 2);
        for (int i = 0; i < bytes.length; i++){
            int intTemp = bytes[i];
            if (intTemp < 0){
                intTemp = intTemp + 256;
            }
            if (intTemp < 16){  //F为15，小于16的数转化为1个字符，需要在前面补0
                sb.append("0");
            }
            //每读取一个字节就将字节转化为16进制字符，添加至字符串
            sb.append(Integer.toString(intTemp,16));
        }
        return sb.toString();
    }

    /**
     * 将16进制的字符串还原为二进制字节数组
     * @param str16
     * @return
     */
    public static byte[] hexStrToByteArr(String str16) {
        byte[] bytes = str16.getBytes();
        byte[] result = new byte[str16.length()/2];
        for (int i = 0; i < str16.length(); i+=2){
            String strTemp = new String(bytes,i,2);
            result[i / 2] = (byte) Integer.parseInt(strTemp, 16);
        }
        return result;
    }
}
