package com.jnshu;

import com.jnshu.model.Message;
import com.jnshu.mapper.MessageDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/springDao.xml")
public class TestMessage {
    @Autowired
    MessageDao messageDao;
    Message message =new Message();

    @Test
    public void add(){
        message.setEditor("赤脚大仙");
        message.setMessage_contents("最多150字");
        message.setMessage_time(System.currentTimeMillis());
        message.setState("精品留言");
        message.setTourist_name("姜子牙");
        message.setWorks_name("乡村小路");
        message.setUpdate_at(System.currentTimeMillis());
      messageDao.addMessage(message);
        System.out.println("id======"+message.getId());
    }
    @Test
    public void delete(){
        System.out.println(messageDao.deleteMessage(200));

    }
    @Test
    public void update(){
        message.setEditor("赤脚大仙");
        message.setMessage_contents("最多150字");
        message.setMessage_time(System.currentTimeMillis());
        message.setState("精品留言");
        message.setTourist_name("姜子牙");
        message.setWorks_name("乡村小路");
        message.setUpdate_at(System.currentTimeMillis());
        message.setId(2);
    }
    @Test
    public void findBy(){
        System.out.println(messageDao.findByMessage(1));
    }
    @Test
    public void findAll(){
        System.out.println(messageDao.findAllMessage());

    }

}
