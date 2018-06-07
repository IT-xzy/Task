package com.fangyuyang.service.serviceImpl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.fangyuyang.model.ALiYunKey;
import com.fangyuyang.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MailServiceImplTest {
    @Autowired
    private MailService mailService;
    @Test
    public void mailSend() {
        System.out.println(mailService.mailSend("2506182162@qq.com"));
    }
    @Autowired
    private ALiYunKey ALiYunKey;
    @Test
    public void mailSend2() {
        System.out.println(",,{}"+mailService.mailSend("2506182162@qq.com"));
    }
}