package com.tools;

import org.junit.Test;


public class MD5Test {





    @Test
    public void bytesToHexString() {
    }

    @Test
    public void hexStringToBytes() {
    }

    @Test
    public void printHexString() {
    }

    @Test
    public void encode() {
        String pwd="aaaaaa";
//        long time=System.currentTimeMillis();
        String salt="321123321312312312";
        String s =MD5.encode(pwd+salt);
        System.out.println(s);
    }
}