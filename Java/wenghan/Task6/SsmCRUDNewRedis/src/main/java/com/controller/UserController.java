package com.controller;

import com.Plug.PageBean;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;


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
    //通过获得请求设置初始页
    public ModelAndView queryAll(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        //通过request获得当前页面
        int pageNum=Integer.valueOf(request.getParameter("pageNum"));
        //设置每页记录数
        int pageSize=5;
        //调用分页方法获得当前页面的记录
        PageBean pageBean=userService.findAllUserWithPage(pageNum,pageSize);
        //通过modelAndView来封装数据
        modelAndView.addObject("list", pageBean);
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
                modelAndView.setViewName("redirect:/UserList?pageNum=1");
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
                modelAndView.setViewName("redirect:/UserList?pageNum=1");
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
            modelAndView.setViewName("redirect:/UserList?pageNum=1");//重定向
        }else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/JSP/{id}",method = RequestMethod.GET)
    public ModelAndView jsp(@PathVariable("id")long id){
        ModelAndView modelAndView=new ModelAndView();
        User user=userService.queryUserById(id);
        if(user!=null) {
            modelAndView.setViewName("jsp");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/JSON/{id}",method = RequestMethod.GET)
    public Object json(@PathVariable("id") long id){
        ModelAndView modelAndView=new ModelAndView();
        User user=userService.queryUserById(id);
        if(user!=null) {
            return user;
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
