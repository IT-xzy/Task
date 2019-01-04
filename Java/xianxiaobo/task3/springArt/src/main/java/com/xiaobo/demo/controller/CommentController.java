package com.xiaobo.demo.controller;

import com.xiaobo.demo.constant.Global;
import com.xiaobo.demo.pojo.*;
import com.xiaobo.demo.pojo.Collection;
import com.xiaobo.demo.service.CommentServiceImpl;
import com.xiaobo.demo.service.UserServiceImpl;
import com.xiaobo.demo.service.WorkServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/a")
public class CommentController {
    private static Logger log = Logger.getLogger(CommentController.class);
    @Autowired
    private CommentServiceImpl commentService;
    @Autowired
    private WorkServiceImpl workService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    Comment comment;
    @Autowired
    Response response;
    @Autowired
    User user;
    @Autowired
    HttpServletRequest request;
    //获取留言列表
    @RequestMapping(value = "/u/comment", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getList(@RequestParam(value = "author",required = false) String author,
                                @RequestParam(value = "type",required = false) String type,
                                @RequestParam(value = "work_id",required = false) String work_id,
                                @RequestParam(value = "page",required = false,defaultValue = "1") String page,
                                @RequestParam(value = "size",required = false,defaultValue = "10") String size){
        // 处理User参数
        Comment comment = new Comment();
        if(author != null && author.length() != 0){
            comment.setAuthor(author);
        }
        if(type != null && type.length() != 0){
            comment.setType(new Integer(type));
        }
        if(work_id != null && work_id.length() != 0){
            comment.setWork_id(new Long(work_id));
        }
        // 处理page和sie
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",(new Integer(page) - 1)* new Integer(size));
        pageData.put("limit",new Integer(size));
        // 查询数据
        List<Comment> commentList = commentService.getList(comment,pageData);

        // 更换pageData
        pageData.put("offset",0);
        pageData.put("limit",1000000);
        //获取用户列表
        ArrayList usernameList = new ArrayList();
        ArrayList workNameList = new ArrayList();
        for(Comment commentItem:commentList){
            Long id = commentItem.getUpdate_by();
            User user = new User();
            user.setId(id);
            List<User> userList = userService.getList(user,pageData);

            if(userList != null&&userList.size()>=1){
                usernameList.add(userList.get(0).getUsername());
            }
            // work
            Long work_id1 = commentItem.getWork_id();
            com.xiaobo.demo.pojo.Work work = new com.xiaobo.demo.pojo.Work();
            work.setId(work_id1);
            List<Work> workList = workService.getList(work,pageData);
            if(workList != null && workList.size()>=1){
                workNameList.add(workList.get(0).getWork_name());
            }
        }

        //获取total
        Integer total = commentService.getList(comment,pageData).size();
        // 拼装数据，返回结果
        ModelAndView modelAndView = new ModelAndView("commentList");
        Response response = new Response(total);
        modelAndView.addObject("response",response);
        modelAndView.addObject("commentList",commentList);
        modelAndView.addObject("usernameList",usernameList);
        modelAndView.addObject("workNameList",workNameList);
        return modelAndView;
    }
    //新增
    @RequestMapping(value = "/u/comment",method = RequestMethod.POST, consumes={"application/json"},produces={"application/json"})
    @ResponseBody
    public ModelAndView add(@Valid @RequestBody Comment comment){
        Object userId = request.getSession().getAttribute(Global.USER_SESSION_KEY);
        comment.setCreate_by(new Long(userId.toString()));
        comment.setUpdate_by(new Long(userId.toString()));
        comment.setCreate_at(new Long(new Date().getTime()));
        comment.setUpdate_at(new Long(new Date().getTime()));
        comment.setType(2);
        Boolean result = commentService.add(comment);
        System.out.println(result);
        Response response;
        if(result){
            response = new Response();
        }else{
            response = new Response(400,"参数错误");
        }
        return new ModelAndView("response","data",response);
    }
    //修改
    @RequestMapping(value = "/u/comment/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ModelAndView update(@RequestBody Comment comment,@PathVariable("id") Long id){
        Object userId = request.getSession().getAttribute(Global.USER_SESSION_KEY);
        comment.setId(id);
        comment.setUpdate_by(new Long(userId.toString()));
        comment.setUpdate_at(new Long(new Date().getTime()));
        Boolean result = commentService.update(comment);
        System.out.println(result);
        Response response;
        if(result){
            response = new Response();
        }else{
            response = new Response(400,"操作失败");
        }
        return new ModelAndView("response","data",response);
    }
    //删除
    @RequestMapping(value = "/u/comment/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ModelAndView delete(@PathVariable("id") Long id){
        Comment comment = new Comment();
        comment.setId(id);
        Boolean result = commentService.delete(comment);
        System.out.println(result);
        Response response;
        if(result){
            response = new Response();
        }else{
            response = new Response(400,"操作失败");
        }
        return new ModelAndView("response","data",response);
    }
}
