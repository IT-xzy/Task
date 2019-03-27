package com.jnshu.service;

import com.jnshu.pojo.Reply;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author pipiretrak
 * @date 2019/3/20 - 3:05
 */
@ContextConfiguration(locations = "classpath:SpringMybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ReplyServiceTest {
    private static Logger logger = Logger.getLogger(ReplyServiceTest.class);


    @Autowired
    ReplyService replyService;
    Reply reply = new Reply();

    @Test
    public void insert(){

        reply.setReplyName("游客1");
        reply.setReplyContent("艺术家简介");
        reply.setCreateAt(System.currentTimeMillis());
        reply.setUpdateAt(System.currentTimeMillis());
        reply.setCreateBy("徐铭培1");
        reply.setUpdateBy("姜子牙1");
        logger.info(String.valueOf(replyService.insert(reply)));
    }

    @Test
    public void update(){

        reply.setReplyName("回复人");
        reply.setReplyContent("回复内容");
        reply.setCreateAt(System.currentTimeMillis());
        reply.setUpdateAt(System.currentTimeMillis());
        reply.setCreateBy("海清");
        reply.setUpdateBy("高愿");
        reply.setReplyId(2);
        logger.info(String.valueOf(replyService.updateByPrimaryKey(reply)));
    }

    @Test
    public void selectByDynamic(){
        logger.info(String.valueOf(replyService.selectByDynamic(null,null)));
    }

    @Test
    public void delete(){
        logger.info(String.valueOf(replyService.deleteByPrimaryKey((long)2)));
    }

}
