package com.jnshu.service;

import com.jnshu.pojo.Message;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author pipiretrak
 * @date 2019/3/20 - 2:56
 */
@ContextConfiguration(locations = "classpath:SpringMybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageServiceTest {
    private static Logger logger = Logger.getLogger(MessageServiceTest.class);

    @Autowired
    MessageService messageService;
    Message message = new Message();

    @Test
    public void insert(){

        message.setName("游客1");
        message.setWorkId(5);
        message.setContent("留言内容");
        message.setStatus(0);
        message.setCreateAt(System.currentTimeMillis());
        message.setUpdateAt(System.currentTimeMillis());
        message.setCreateBy("徐铭培1");
        message.setUpdateBy("姜子牙1");
        logger.info(String.valueOf(messageService.insert(message)));
    }

    @Test
    public void update(){

        message.setName("游客2");
        message.setWorkId(6);
        message.setContent("留言内容1");
        message.setStatus(0);
        message.setCreateAt(201);
        message.setUpdateAt(2011);
        message.setCreateBy("DFS02");
        message.setUpdateBy("ARWER102");
        message.setMsgId(6);
        logger.info(String.valueOf(messageService.updateByPrimaryKey(message)));
    }

    @Test
    public void selectByDynamic(){
        logger.info(String.valueOf(messageService.selectByDynamic(null,null)));
    }

    @Test
    public void delete(){
        logger.info(String.valueOf(messageService.deleteByPrimaryKey((long)2)));
    }
}


