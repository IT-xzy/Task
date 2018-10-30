package com.jnshu.controller;

import com.jnshu.entity.Comment;
import com.jnshu.service.CommentService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/a/u")
public class CommentController {
    Logger logger = LogManager.getLogger(FirstController.class.getName());

    @Autowired
    CommentService commentService;
    //搜索获取留言
    @RequestMapping(value = "/comment/list/{aid}", method = RequestMethod.GET)
    public ModelAndView getComment(@PathVariable long aid , ModelAndView modelAndView){
        logger.info("getComment====\n"+ "id=====" + aid );
        if (aid > 0 && aid % 1 == 0) {
            Comment comment = new Comment();
            comment.setArtId(aid);
             List commentList = commentService.select(comment);
            if(commentList!=null){
                logger.info(commentList.toString());
                Map<String, Object> map = new HashMap<>();
                modelAndView.addObject("comment", commentList);
                modelAndView.addObject("code", 100);//查找成功
            }else{
                logger.info("您所查找的作品不存在\n");
                modelAndView.addObject("code", -101);//您所查找的作品不存在
            }
        } else {
            logger.info("请输入一个正整数\n");
            modelAndView.addObject("code", -100);//请输入一个正整数
            //modelAndView.addObject("message", "findAll failed");
            //不存在的时候将返回给jsp页面的data值设置为空，如果不设置，会显示data中以前残留的数据
        }
        modelAndView.setViewName("showCommentJsonFormat");
        return modelAndView;
    }
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public ModelAndView  addComment(String nick,String content,Long artId,boolean type, ModelAndView modelAndView){
            if(nick != null && content != null && (artId >0 && artId % 1==0)&& type){
                Comment comment = new Comment();
                comment.setNick(nick);
                comment.setContent(content);
                comment.setArtId(artId);
                comment.setType(true);
                comment.setUpdateAt(System.currentTimeMillis());
                if(commentService.insertSelective(comment) >0){
                    modelAndView.addObject("code", comment);
                    modelAndView.addObject("code", 100);//成功
                }else{
                    modelAndView.addObject("code", -100);//失败
                }
            }else{
                logger.info("请检查您的输入是否都不为空\n");
                modelAndView.addObject("code", -102);//请检查您的输入是否都不为空
            }
        modelAndView.setViewName("showCommentJsonFormat");
        return modelAndView;
    }
    //获取留言回复
    @RequestMapping(value = "/comment/reply/{rid}", method = RequestMethod.GET)
    public ModelAndView getReplyComment(@PathVariable long rid , ModelAndView modelAndView){
        logger.info("getComment====\n"+ "rid=====" + rid );
        if (rid > 0 && rid % 1 == 0) {
            Comment reply = new Comment();
            reply.setReplyId(rid);
            List replyList = commentService.select(reply);
            if(replyList != null){
                logger.info(replyList.toString());
                Map<String, Object> map = new HashMap<>();
                modelAndView.addObject("comment", replyList);
                modelAndView.addObject("code", 100);//查找成功
            }else{
                logger.info("您所查找的作品不存在\n");
                modelAndView.addObject("code", -101);//您所查找的作品不存在
            }
        } else {
            logger.info("请输入一个正整数\n");
            modelAndView.addObject("code", -100);//请输入一个正整数
        }
        modelAndView.setViewName("showCommentJsonFormat");
        return modelAndView;
    }

}
