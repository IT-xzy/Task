package com.MD;

import com.tools.DESUtil;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.Base64;

import static org.junit.Assert.*;

public class MD1Test {




    @Test
    public void calcMD1() {
        String string=MD1.calcMD1("aaaaa");

        System.out.println(string);
    }

    @Test
    public void DES(){
        String st="one peaces";
        String s1= DESUtil.encryptBasedDes(st);
        System.out.println("加密后的数据是"+s1);
        String s2=DESUtil.decryptBasedDes(s1);
        System.out.println("解密后的数据是"+s2);
    }




}