package com.artist.dao;

import com.artist.pojo.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageDaoTest {
    @Autowired
    private MessageDao messageDao;

    @Test
    public void queryMessages() {
        List<Message> list =messageDao.queryMessages(2);
        System.out.println(list);
    }

    @Test
    public void delMdessage() {
        Integer integer=messageDao.delMdessage(2);
        System.out.println(integer);
    }

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
        Integer integer=  messageDao.saveMessage(m);
        System.out.println(integer);
    }

    @Test
    public void updateMessage() {
        Message m =new Message();
        m.setMessageId(1);
        m.setNick("游客1");
        m.setMessage("这篇文章写的很好，完全写在我的心境啊");
        m.setProductionId(1);
        m.setType("0");
        m.setSelection("1");
        m.setCreateTime(1538538977088L);
        m.setUpdateTime(System.currentTimeMillis());
        messageDao.updateMessage(m);

    }
}