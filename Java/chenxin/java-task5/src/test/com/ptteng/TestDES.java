package com.ptteng;

import com.ptteng.util.CipherDES;
import com.ptteng.util.DESAlgorithm;
import org.junit.Test;
import sun.reflect.annotation.ExceptionProxy;

import static com.ptteng.util.CipherDES.*;

public class TestDES {
    public static CookieTest cookieTest;
    @Test
    public  void mainE() throws Exception {
        CipherDES cipherDES = new CipherDES();
        String data = "123";
        byte[] key = cipherDES.initKey();
        key = "12345678".getBytes();

        byte[] resultBytes = cipherDES.encryptDES(key, data.getBytes());
        String resultString = cipherDES.bytesToHexString(resultBytes);
        for (int i = 0; i < key.length; i++) {
            System.out.print(key + "，");
        }
        System.out.println();

        System.out.println(data + "加密结果为：");
        //2c388551d7f489ec
        System.out.println(resultString);


        String decryptResult = cipherDES.decryptDES(key, resultBytes);

        System.out.println("解密结果为:");
        System.out.println(decryptResult);

    }
    @Test
    public void encryptStingTest() throws Exception{
        String s = "123";
        String key = "wang!@#$%";
        DESAlgorithm desAlgorithm = new DESAlgorithm();
        //加密过程
        String p = desAlgorithm.encrypt(s, key);
        System.out.println(p);
        System.out.println(desAlgorithm.decrypt(p,key));

    }

}
