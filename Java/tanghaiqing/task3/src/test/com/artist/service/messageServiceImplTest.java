package com.artist.service;

import com.artist.pojo.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class messageServiceImplTest {
    @Resource(name= "MessageServiceImpl")
    private MessageService messageService;

    @Test
    public void saveMessage() {
        Message m =new Message();
        m.setNick("魏天");
        m.setMessage("这是在广州拍的");
        m.setProductionId(2);
        m.setType("1");
        m.setSelection("1");
        m.setReplyId(2);
        m.setCreateTime(System.currentTimeMillis());
        m.setUpdateTime(System.currentTimeMillis());
       String str= messageService.saveMessage(m);
        System.out.println(str);
    }
}