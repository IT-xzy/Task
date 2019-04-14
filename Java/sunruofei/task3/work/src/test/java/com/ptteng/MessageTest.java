package com.ptteng;


import com.ptteng.model.Message;
import com.ptteng.service.MessageService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration("classpath:/spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageTest {
    @Autowired
    MessageService messageService;
    Message message =new Message();
    Logger logger = Logger.getLogger(Message.class);
    @Test
    public void insert(){
         message.setCreateAt(2132L);
         message.setCreateBy(2L);
         message.setMessage("画的真好");
         message.setParentId(3L);
         message.setState(2L);
         message.setType((byte)5);
         message.setWorkId(1L);
         message.setUserName("小猫");
         message.setUpdateAt(2019L);
         message.setUpdateBy(3L);
        logger.info(messageService.insert(message));
    }
    @Test
    public void deleteByPrimaryKey(){
        logger.info(messageService.deleteByPrimaryKey(3L));
    }
    @Test
    public void updateByPrimaryKey(){
        message.setCreateAt(2012L);
        message.setCreateBy(2L);
        message.setMessage("画的真好");
        message.setParentId(3L);
        message.setState(2L);
        message.setType((byte)5);
        message.setWorkId(1L);
        message.setUserName("小王");
        message.setUpdateAt(2019L);
        message.setUpdateBy(3L);
        message.setId(4L);
        logger.info(messageService.updateByPrimaryKey(message));
    }
    @Test
    public void selectByPrimaryKey(){
        logger.info(messageService.selectByPrimaryKey(4L));
    }
    @Test
    public void selectAll(){
        logger.info(messageService.selectAll());
    }
    @Test
    public void selectByDynamicCondition(){
        logger.info(messageService.selectByDynamicCondition("梵高的老舅",3L));
    }

}
