package com.longhang.util;

public class Token {
    private final String password = "1234567887654321";

    public String makeToken1(String name, Long upTime) {
        String str = name + upTime.toString();
        String s = DES.encryptDES(str, password);
        //System.out.println(new String(s));
        return s;
        }
    //加密
    public String makeToken(String name) {

        String s = DES.encryptDES(name, password);
        //System.out.println(new String(s));
        return s;
    }
    //解密
    public String SolveToken(String s) {
        String s1 = null;
        try {
            s1 = DES.decryptDES(s, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(new String(s1));
            return s1;
        }

}



