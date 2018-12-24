package jnshu.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MD5 {
    /**
     * @param psd
     * @param salt
     * @return MD5加密后的字符串
     * @Des 得到相应的一个MD5加密后的字符串
     */
    public static String encoder(String psd, String salt) {
        try {
            StringBuffer stingBuffer = new StringBuffer ();
            // 1.指定加密算法
            MessageDigest digest = MessageDigest.getInstance ("MD5");
            // 2.将需要加密的字符串转化成byte类型的数据，然后进行哈希过程
            byte[] bs = digest.digest ((psd + salt).getBytes ());
            // 3.遍历bs,让其生成32位字符串，固定写法

            // 4.拼接字符串
            for (byte b : bs) {
                int i = b & 0xff;

//                java.lang.Integer.toHexString()-
// 此方法返回的字符串表示的无符号整数参数所表示的值以十六进制（基数为16）
                String hexString = Integer.toHexString (i);
                if (hexString.length () < 2) {
                    hexString = "0" + hexString;
                }
                stingBuffer.append (hexString);
            }
            return stingBuffer.toString ();
        } catch ( NoSuchAlgorithmException e ) {
            e.printStackTrace ();
        }
        return null;
    }

    /**
     * 盐值
     */
    public static String salt() {
        Random r = new Random ();
        StringBuilder sb = new StringBuilder (16);
        sb.append (r.nextInt (99999999)).append (r.nextInt (99999999));
        int len = sb.length ();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append ("0");
            }
        }
        String salt = sb.toString ();
        return salt;
    }

    //    校验加盐后是否和原文一致
    public static boolean verify(String pwdMD5, String password, String salt) {

        return encoder (password, salt).equals (pwdMD5);
    }

    //    测试
    public static void main(String[] args) {
        String sa = salt ();//生成盐
        String rs1 = encoder ("zgy123456", sa);//密文
        String rs2 = encoder ("zgy123456", sa);//

        System.out.println (rs1);
        System.out.println (rs2);

        Boolean b = verify (rs1, "zgy123456", sa);
        System.out.println (b);

    }

}
