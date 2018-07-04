package com.controller;

import com.Plug.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.User;
import com.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }
    //查询全表:User GET
    @RequestMapping(value = "/UserList", method = RequestMethod.GET)
    public ModelAndView queryAll(Page page) {
        ModelAndView modelAndView = new ModelAndView();
        //（页面开始值，页面值数）
        PageHelper.offsetPage(page.getStart(),6);
        List<User> list = userService.queryUser();
        //获得数据的总数
        int total = (int) new PageInfo<>(list).getTotal();
        //计算最后一页的开始值
        page.caculateLast(total);
        modelAndView.addObject("list", list);
        modelAndView.setViewName("User");
        return modelAndView;
    }

    //添加 User POST
    @RequestMapping(value = "/User",method = RequestMethod.POST)
    public ModelAndView add(User user){
        ModelAndView modelAndView = new ModelAndView();
        if(!(user.getName().equals("")||user.getQq().equals(""))) {
            boolean operation = userService.addUser(user);
            if (operation) {
                modelAndView.setViewName("redirect:/UserList");
            } else {
                modelAndView.setViewName("error");
            }
        }else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    //编辑/查询一个用户：User{id}GET
    @RequestMapping(value = "/User/{id}",method = RequestMethod.GET)
    public ModelAndView editORQuery(@PathVariable("id")long id,
        @RequestParam(value = "name",required = false)String name){
        ModelAndView modelAndView = new ModelAndView();
        if(name==null) {//编辑逻辑
            User user = userService.queryUserById(id);
            if (user != null) {
                modelAndView.addObject("object", user);
                modelAndView.setViewName("edit");
            } else {
                modelAndView.setViewName("error");
            }
        }else{//查询逻辑
            User user = userService.queryUserById(id);
            if (user != null) {
                modelAndView.addObject("object", user);
                modelAndView.setViewName("query");
            } else {
                modelAndView.setViewName("error");
            }
        }
        return modelAndView;
    }

    //更新一个用户 User PUT
    @RequestMapping(value = "/User",method =RequestMethod.PUT)
    public ModelAndView update(User user){
        ModelAndView modelAndView = new ModelAndView();
        if(!(user.getName().equals("")||user.getQq().equals(""))){
            boolean operation = userService.reviseUserById(user);
            if (operation) {
                modelAndView.setViewName("redirect:/UserList");
            } else {
                modelAndView.setViewName("error");
            }
        }else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    //删除: User {id}  DELETE
    @RequestMapping(value = "/User/{id}",method = RequestMethod.DELETE)
    public ModelAndView delate(@PathVariable("id")long id){
        ModelAndView modelAndView=new ModelAndView();
        boolean operation=userService.cutUserById(id);
        if(operation){
            modelAndView.setViewName("redirect:/UserList");//重定向
        }else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

}
