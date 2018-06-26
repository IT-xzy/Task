package com.DES;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

///**
//// * 加解密工具类
//// * @ClassName: DESUtil
//// * @Description:加解密工具类
//// * @author: 王钧
//// * @date 2015-11-15
//// */
public class DESUtil {

//        /**
//         * 加密
//         * @param datasource byte[]
//         * @param password String
//         * @return byte[]
//         */
    public static String encrypt(byte[] datasource, String username) {
        try{
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(username.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密encrypt_mode,
            //正式执行加密操作
            return byteArr2HexStr(cipher.doFinal(datasource));
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }


    //    /**
//     * 解密
//     * @param src byte[]
//     * @param password String
//     * @return byte[]
//     * @throws Exception
//     */
    public static byte[] decrypt(byte[] src, String username) throws Exception {
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(username.getBytes());
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            // 真正开始解密操作
            return cipher.doFinal(src);
        }catch (Exception e){
            System.out.println("解密");
        }
        return null;
    }

    //    /**
//     * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
//     * hexStr2ByteArr(String strIn) 互为可逆的转换过程
//
//     *
//     * @param arrB
//     *            需要转换的byte数组
//
//     * @return 转换后的字符串
//     * @throws Exception
//     *             本方法不处理任何异常，所有异常全部抛出
//     */
    public  static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        // 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍

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

    //    /**
//     * 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[] arrB)
//     * 互为可逆的转换过程
//
//     *
//     * @param strIn
//     *            需要转换的字符串
//     * @return 转换后的byte数组
//
//     * @throws Exception
//     *             本方法不处理任何异常，所有异常全部抛出
//     */
    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        try{
            byte[] arrB = strIn.getBytes();
            int iLen = arrB.length;

            // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
            byte[] arrOut = new byte[iLen / 2];
            for (int i = 0; i < iLen; i = i + 2) {
                String strTmp = new String(arrB, i, 2);
                arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
            }
            return arrOut;
        }
        catch (Exception e){
            System.out.println("转为byte数组");
        }
        return null;
    }

    //随机生成密钥
    private static String getKey() throws Exception{
        //       DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 为我们选择的DES算法生成一个KeyGenerator对象
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        kg.init(sr);
        // 生成密匙
        SecretKey key = kg.generateKey();
        // 获取密匙数据
        byte rawKeyData[] = key.getEncoded();

        //return new String(rawKeyData);

        return byteArr2HexStr(rawKeyData);
    }


    // controller  des 加密 调用
    public static String[] tool (String str, String aa) throws UnsupportedEncodingException {

        String key= "9588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456";
        String tok = DESUtil.encrypt(str.getBytes("UTF8"),key);//将用户信息进行DES加密
        String tok2 = DESUtil.encrypt(aa.getBytes("UTF8"),key);// 登陆时间加密
        return  new String[]{tok,tok2};
    }

    // 拦截器 des解密封装
    public static String[] tool2(String[] st) throws Exception {

        String key = "9588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456";

        byte[]  username = DESUtil.decrypt(hexStr2ByteArr(st[0]), key);
        byte[] landtime = DESUtil.decrypt(hexStr2ByteArr(st[1]), key);
        String un = new String(username);
        String lt = new String(landtime);
        return new String[]{un,lt};
    }


//    /**
//     * @param args
//     * @throws Exception
////     */
//    public static void main(String[] args) throws Exception {
//
//        //待加密内容
//        String str = "asong";
//        //密码，长度要是8的倍数
//        String key = "9588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456";
//
//        //随机生成密钥
//       // key=getKey();
//
//        String result = DESUtil.encrypt(str.getBytes("UTF8"),key);
//        System.out.println("加密后："+result);
//
//        //直接将如上内容解密
//        try {
//            byte[] decryResult = DESUtil.decrypt(hexStr2ByteArr(result), key);
//            System.out.println("解密后："+new String(decryResult));
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//    }



}

