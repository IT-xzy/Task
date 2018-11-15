package com.art.service;

import com.art.pojo.Comment;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author suger
 * @date 2018/11/14 11:42
 */
public class CommentServiceTest {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
    static Logger log = Logger.getLogger(CommentServiceTest.class);
    CommentService commentService = ctx.getBean(CommentService.class);


    @Test
    public void delete() throws Exception {
        int id = 1;
        boolean b = commentService.delete(id);
        log.info("删除结果："+b);
    }

    @Test
    public void insert() throws Exception {

        Comment comment = new Comment();
        comment.setNick("展飞");
        comment.setWorkId(1);
        comment.setStatus(true);
        comment.setContent("画的不错哎！多交流");
        comment.setStatus(true);
        comment.setType(true);
        boolean b = commentService.insert(comment);
        log.info("新增结果:"+b);
    }

    @Test
    public void getComment() throws Exception {

        int id = 1;
        log.info("根据id查询："+commentService.getComment(id));
    }

    @Test
    public void getComments() throws Exception {
        // 包装类型可以为 null ,基本类型 不可以为 null
       // boolean status = null;
        Boolean status = null;
        String fromBy = null;
        log.info("条件查询："+commentService.getComments(status,fromBy));
    }

    @Test
    public void update() throws Exception {

        Comment comment = new Comment();
        comment.setNick("更新");
        comment.setWorkId(1);
        comment.setStatus(true);
        comment.setContent("画的不错哎！多交流");
        comment.setStatus(false);
        comment.setType(false);
        boolean b = commentService.insert(comment);
        log.info("更新结果:"+b);
    }

}