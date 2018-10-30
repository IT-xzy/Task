package com.jnshu;

import com.jnshu.model.Reply;
import com.jnshu.mapper.ReplyDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/springDao.xml")
public class TestReply {
    @Autowired
    ReplyDao replyDao;
    Reply reply = new Reply();

    @Test
    public void  add(){
        reply.setWorks_name("乡间小路");
        reply.setCreate_at(System.currentTimeMillis());
        reply.setEditor("小红帽");
        reply.setMessage_contents("此处省略150字");
        reply.setReply_time(System.currentTimeMillis());
        reply.setUpdate_at(System.currentTimeMillis());
        reply.setReply_content("此处省略150字");
        replyDao.addReply(reply);
        System.out.println("id======"+reply.getId());

    }
    @Test
    public void delete(){
        System.out.println(replyDao.deleteReply(100));
    }
    @Test
    public void update(){
        reply.setWorks_name("乡间小路");
        reply.setCreate_at(System.currentTimeMillis());
        reply.setEditor("小红帽");
        reply.setMessage_contents("此处省略150字");
        reply.setReply_time(System.currentTimeMillis());
        reply.setUpdate_at(System.currentTimeMillis());
        reply.setReply_content("此处省略150字");
        reply.setId(2);
        System.out.println(replyDao.updateReply(reply));
    }

    @Test
    public void findBy(){
        System.out.println(replyDao.findByReply(1));

    }

    @Test
    public void findAll(){
        System.out.println(replyDao.findAllReply());

    }

}
