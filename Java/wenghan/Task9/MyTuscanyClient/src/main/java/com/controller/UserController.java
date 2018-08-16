package com.controller;

import com.Plug.PageBean;
import com.pojo.User;
import com.service.Service;
import com.tool.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }
    //查询全表:User GET
    @RequestMapping(value = "/UserList", method = RequestMethod.GET)
    public ModelAndView queryAll(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        //通过request获得当前页面
        int pageNum=Integer.valueOf(request.getParameter("pageNum"));
        //设置每页记录数
        int pageSize=5;
        Service service=new MyService().getService();
        //调用分页方法获得当前页面的记录
        PageBean pageBean = service.findAllUserWithPage(pageNum, pageSize);
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
            Service service=new MyService().getService();
            boolean operation = service.addUser(user);
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
        if(name==null) {
            Service service=new MyService().getService();
            //编辑逻辑
            User user = service.queryUserById(id);
            if (user != null) {
                modelAndView.addObject("object", user);
                modelAndView.setViewName("edit");
            } else {
                modelAndView.setViewName("error");
            }
        }else{
            Service service=new MyService().getService();
            //查询逻辑
            User user = service.queryUserById(id);
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
            Service service=new MyService().getService();
            boolean operation = service.reviseUserById(user);
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
        Service service=new MyService().getService();
        boolean operation=service.cutUserById(id);
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
        Service service=new MyService().getService();
        User user=service.queryUserById(id);
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
    public Object json(@PathVariable("id")long id){
        ModelAndView modelAndView=new ModelAndView();
        Service service=new MyService().getService();
        User user=service.queryUserById(id);
        if(user!=null) {
            return user;
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
