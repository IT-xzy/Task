package com.ptteng;

import org.junit.Test;

import java.util.UUID;

public class TokenTest {
    @Test
    public void getToken() {
        System.out.println("UUID随机生成唯一字符串是（替换了”-“）："+UUID.randomUUID().toString().replace("-", "*"));
        //UUID随机生成唯一字符串是（替换了”-“）：4f88482282c64dfda2e29f92ef77fbb3
        System.out.println("UUID随机生成唯一字符串是："+UUID.randomUUID().toString());
        //UUID随机生成唯一字符串是：b4fe3028-6067-4388-9774-40d152a8911f
    }
}
