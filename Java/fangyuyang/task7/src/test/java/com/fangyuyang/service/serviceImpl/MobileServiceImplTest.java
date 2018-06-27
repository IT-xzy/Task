package com.fangyuyang.service.serviceImpl;

import com.fangyuyang.service.MobileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MobileServiceImplTest {
 @Autowired
 private MobileService mobileService;
    @Test
    public void sendMessages() {
        System.out.println(mobileService.sendMessages("18819452550"));
    }

    @Test
    public void messagesCheck() {
        System.out.println( mobileService.MessagesCheck("18819452550"));
    }
}