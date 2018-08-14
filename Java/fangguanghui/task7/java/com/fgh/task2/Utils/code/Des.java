package com.fgh.task2.Utils.code;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class Des {

    /**
     * 加密
     * @param data
     * @param sKey
     * @return
     */
    public static byte[] encrypt(byte[]data , String sKey) {


        try {
           byte[] key = sKey.getBytes();
//            SecureRandom random=new SecureRandom();
            /*
            IgetvParameterSpec是一个用于规范加密参数的接口的实现类之一
            指定一个初始向量iv.使用iv的例子是反馈模式中的密码，如CBC模式中的
            DES和使用OAEP编码操作的RSA密码
            */
            //初始化变量
            IvParameterSpec iv = new IvParameterSpec(key);
            DESKeySpec desKey = new DESKeySpec(key);
            //创建一个秘钥工厂，然后用它把DESKeySpec转换成securekey
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            //用秘钥初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, secretKey,iv);
            //获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(data);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * @param src
     * @param skey
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, String skey)throws Exception{
        byte[] key=skey.getBytes();
//        SecureRandom random=new SecureRandom();
        IvParameterSpec iv = new IvParameterSpec(key);
        DESKeySpec desKeySpec = new DESKeySpec(key);
        //创建一个秘钥工厂
        SecretKeyFactory secretKeyFactory=SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey secretKey=secretKeyFactory.generateSecret(desKeySpec);
        // Cipher对象实际完成解密操作
        Cipher cipher=Cipher.getInstance("DES/CBC/PKCS5Padding");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE,secretKey,iv);
        return  cipher.doFinal(src);
    }

    /**
     * 将二进制转化为16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]){
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<buf.length;i++){
            String hex=Integer.toHexString(buf[i] & 0xFF);
            if(hex.length()==1){
                hex = '0'+hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     *16进制转二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStrByte2(String hexStr){
        if(hexStr.length()<1) return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i=0;i < hexStr.length()/2;i++){
            int high = Integer.parseInt
                    (hexStr.substring(i*2, i * 2 + 1),16);
            int low = Integer.parseInt(hexStr.substring
                    (i * 2 + 1, i * 2 + 2),16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}
