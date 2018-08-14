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
        String s =MD5.encode(pwd);
        System.out.println(s);
    }
}