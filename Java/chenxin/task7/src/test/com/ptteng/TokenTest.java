package com.ptteng;

import com.ptteng.controller.ShortMessageController;
import com.ptteng.model.User;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TokenTest {

    @Test
    public void getToken() {
        System.out.println("UUID随机生成唯一字符串是（替换了”-“）："+UUID.randomUUID().toString().replace("-", "*"));
        //UUID随机生成唯一字符串是（替换了”-“）：4f88482282c64dfda2e29f92ef77fbb3
        System.out.println("UUID随机生成唯一字符串是："+UUID.randomUUID().toString());
        //UUID随机生成唯一字符串是：b4fe3028-6067-4388-9774-40d152a8911f
    }
    @Test
    public void testMock(){
        User mockUser = mock(User.class);
        System.out.println("********************");
        System.out.println(mockUser.getUsername());
        mockUser.setUsername("dsfds");
        System.out.println(mockUser.getUsername());
        System.out.println(mockUser);
        System.out.println(mockUser.toString());
        verify(mockUser,times(2));
    }
    @Test
    public void randomTest() {
        Random random = new Random(222222);
        System.out.println(random.nextInt());
        System.out.println((int)((Math.random()*9+1)*100000));
        System.out.println((int)((Math.random()*9+1)*1000));
    }
    @Test
    public void t(){
        String d = "https://imageuploadbychenxin.oss-cn-hangzhou.aliyuncs.com/"
                + 12 + "/"+12 +"."+ "fileName";
        System.out.println(d.length());
    }

}
