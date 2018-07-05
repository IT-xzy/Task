package com.jnshu.tools;

import org.junit.Test;


public class MD5UtilTest {
    @Test
    public void stringToMD5() {
        System.out.println("md5加密的liuhuan: " + MD5Util.stringToMD5("123456"));
    }
}