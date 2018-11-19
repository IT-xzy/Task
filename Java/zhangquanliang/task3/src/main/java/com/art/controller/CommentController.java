package com.art.controller;

import com.art.pojo.Banner;
import com.art.pojo.Comment;
import com.art.service.BannerService;
import com.art.service.CommentService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 留言管理
 * @author suger
 * @date 2018/11/6 20:06
 */
@Controller
public class CommentController {
    private static final Logger logger= LogManager.getLogger(CommentController.class);
    @Autowired
    CommentService commentService;
    @GetMapping(value = "a/u/comment/{id}")
    @ResponseBody
    public Map<String,Object> getBanner(@PathVariable Integer id) {
        Map<String,Object> result = new HashMap<String, Object>();
        Comment comment = commentService.getComment(id);
        if (comment != null){
            result.put("message","查询成功");
            result.put("code",200);
            result.put("data",comment);

        }else {
            result.put("message","查询失败");
            result.put("code",400);
            result.put("data","ID对应的数据为空");
        }
        return result;
    }

    // 查询 评论 列表
    @GetMapping(value = "/a/u/comment")
    @ResponseBody
    public Map<String,Object> list(@RequestParam(value = "status",required = false) Boolean status,
                                   @RequestParam(value = "fromBy",required = false) String fromBy) {
        Map<String,Object> result = new HashMap<String, Object>();
          List<Comment>  comments = commentService.getComments(status,fromBy);

        logger.info(comments);
        // 留言对应的list不存在或者，或者留言是空白的 ，长度为0
        if (comments == null || comments.isEmpty()){

            result.put("message","查询失败");
            result.put("code",400);
            result.put("data","找不到对应的留言");

        }else {
            result.put("message","查询成功");
            result.put("code",200);
            result.put("data",comments);
        }
        return result;
    }

    // 新增留言   ----不需要登录
    @RequestMapping(value = "/a/comment",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveComment(Comment comment){
        Map<String,Object> result = new HashMap<String, Object>();

        logger.info(comment);
        if (commentService.insert(comment)){
            result.put("code",200);
            result.put("message","添加成功");
        }else {
            result.put("code",400);
            result.put("message","添加失败");
        }
        return result;
    }

    // 删除 banner
    @RequestMapping(value = "/a/u/comment/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object>  deleteComment(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<String, Object>();
        logger.info(id);
        if(commentService.delete(id)) {
            result.put("code", 200);
            result.put("message", "删除成功");
        }else {
            result.put("code", 400);
            result.put("message", "删除失败,留言不存在");
        }
        return result;
    }

    //更新 banner
    @RequestMapping(value = "/a/u/comment/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateComment(@PathVariable Integer id, Comment comment){
        Map<String,Object> result = new HashMap<String, Object>();
        logger.info(comment);
        if (commentService.update(comment)){
            result.put("code", 200);
            result.put("message", "更新成功");
        }else {
            result.put("code", 400);
            result.put("message", "更新失败");
        }
        return result;
    }
}
