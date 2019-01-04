package com.xiaobo.demo.controller;

import com.xiaobo.demo.constant.Global;
import com.xiaobo.demo.pojo.About;
import com.xiaobo.demo.pojo.Response;
import com.xiaobo.demo.pojo.User;
import com.xiaobo.demo.service.AboutServiceImpl;
import com.xiaobo.demo.service.UserServiceImpl;
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
public class AboutController {
    private static Logger log = Logger.getLogger(AboutController.class);
    @Autowired
    private AboutServiceImpl aboutService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    About about;
    @Autowired
    Response response;
    @Autowired
    User user;
    @Autowired
    HttpServletRequest request;
    //获取所有工作室
    @RequestMapping(value = "/u/about", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getList(@RequestParam(value = "about_type",required = false) String about_type,
                                @RequestParam(value = "status",required = false) String status,
                                @RequestParam(value = "page",required = false,defaultValue = "1") String page,
                                @RequestParam(value = "size",required = false,defaultValue = "10") String size){
        // 处理User参数
        About about = new About();
        if(about_type != null && about_type.length() != 0){
            about.setAbout_type(new Integer(about_type));
        }
        if(status != null && status.length() != 0){
            about.setStatus(new Integer(status));
        }
        // 处理page和sie
        Map<String,Object> pageData = new HashMap<>();
        pageData.put("offset",(new Integer(page) - 1)* new Integer(size));
        pageData.put("limit",new Integer(size));
        // 查询数据
        List<About> aboutList = aboutService.getList(about,pageData);

        // 更换pageData
        pageData.put("offset",0);
        pageData.put("limit",1000000);
        //获取用户列表
        ArrayList usernameList = new ArrayList();
        for(About aboutItem:aboutList){
            Long id = aboutItem.getUpdate_by();
            User user = new User();
            user.setId(id);
            List<User> userList = userService.getList(user,pageData);

            if(userList != null&&userList.size()>=1){
                usernameList.add(userList.get(0).getUsername());
            }
        }

        //获取total
        Integer total = aboutService.getList(about,pageData).size();
        // 拼装数据，返回结果
        ModelAndView modelAndView = new ModelAndView("aboutList");
        Response response = new Response(total);
        modelAndView.addObject("response",response);
        modelAndView.addObject("aboutList",aboutList);
        modelAndView.addObject("usernameList",usernameList);
        return modelAndView;
    }
    //新增
    @RequestMapping(value = "/u/about",method = RequestMethod.POST, consumes={"application/json"},produces={"application/json"})
    @ResponseBody
    public ModelAndView add(@Valid @RequestBody About about){
        Object userId = request.getSession().getAttribute(Global.USER_SESSION_KEY);
        about.setCreate_by(new Long(userId.toString()));
        about.setUpdate_by(new Long(userId.toString()));
        about.setCreate_at(new Long(new Date().getTime()));
        about.setUpdate_at(new Long(new Date().getTime()));
        about.setStatus(2);
        Boolean result = aboutService.add(about);
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
    @RequestMapping(value = "/u/about/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ModelAndView update(@Valid @RequestBody About about,@PathVariable("id") Long id){
        Object userId = request.getSession().getAttribute(Global.USER_SESSION_KEY);
        about.setId(id);
        about.setUpdate_by(new Long(userId.toString()));
        about.setUpdate_at(new Long(new Date().getTime()));
        Boolean result = aboutService.update(about);
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
    @RequestMapping(value = "/u/about/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ModelAndView delete(@PathVariable("id") Long id){
        About about = new About();
        about.setId(id);
        Boolean result = aboutService.delete(about);
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
