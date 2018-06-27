package util;

/**
 * 字符串转换工具
 */
public class StrConvertUtil {
/**
 * 将byte数组转换为表示16进制值的字符串，如：byte[]{8,18}转换为：0812，
 * 和public static byte[] hexStrToByteArr(String strIn) 互为可逆的转换过程
 */
   public static String byteArrToHexStr(byte[] arrByte){
       int iLen =arrByte.length; //byte[] 数组长度
       StringBuffer sb=new StringBuffer(iLen*2);//每个byte（8位）用两个（16进制）表示
       for (int i=0;i<iLen;i++){
           int intTemp =arrByte[i];
           while (intTemp<0){//把负数转换为正数
               intTemp =intTemp+256;
           }
           if(intTemp<16){ //小于0F的前面补0
               sb.append("0");
           }
           sb.append(Integer.toString(intTemp,16));
       }
       return sb.toString();
   }

    /**
     * 将16进制的字符串转换成byte数组
     * 和public static String byteArrToHexStr(byte[] arrB)互为可逆转换过程
     */
    public static byte[] hexStrToByteArr(String strIn){
        if(strIn == null || strIn.trim().equals("")) {
            return new byte[0];
        }
        byte[] bytes = new byte[strIn.length() / 2];
        for(int i = 0; i < strIn.length() / 2; i++) {
            String subStr = strIn.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }
}
