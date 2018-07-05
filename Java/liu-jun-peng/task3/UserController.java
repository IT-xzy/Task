package com.oto.controller;

import com.oto.pojo.User;
import com.oto.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

import org.apache.log4j.Logger;


/**
 * @author: 刘军鹏
 * @program: demo
 * @description:
 * @create: 2018/5/22 下午1:03
 */


@Controller
@RequestMapping("/demo")
@SessionAttributes("pageTimes")
public class UserController {
    
//    @InitBinder
//    public void initBainder(DataBinder binder){
//        binder.replaceValidators(new UserValidator());
//
//    }
    
    @Autowired
    private UserServiceImpl userServiceImpl;
    
    @Value("#{configProperties['userPageSize']}")
    private String userPageSize;
   private static Logger logger = Logger.getLogger(UserController.class);
    
    
    //    跳转到添加用户界面
    @RequestMapping("/toAddUser")
    public String toAddUser() {
        logger.info("成功了!");
        return "/addUser";
        
        
    }
    
    
    //    跳转到查找界面
    @RequestMapping("/tofindUser")
    public String findUser() {
        
        return "findUser";
        
    }
    
    //    查询所有用户
//    @RequestMapping("/getAllUser")
//    public String getAllUser(HttpServletRequest request, Model model) {
//        List<User> user = userServiceImpl.findAll();
//        model.addAttribute("userList", user);
//        request.setAttribute("userList",user);
//        return "/allUser";
//    }
    
    //    添加用户并重定向
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser( User user) {
       
            userServiceImpl.addUser(user);
       
//        if(user.getName()==""){
//            modle.addAttribute("error","错误");
//
//            return "error";
//
//        }
        
        return "redirect:/demo/getAllUser";
        
    }
    /*
    修改用户
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public String UpdateUser(User user, HttpServletRequest request, Model modle) {
        if (userServiceImpl.updateUser(user)) {
            user = userServiceImpl.findUserById(user.getId());
            request.setAttribute("user", user);
            modle.addAttribute("user", user);
            return "redirect:/demo/getAllUser";
        } else {
            return "error";
        }
    }
    
    
    //    查询单个用户
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser(String id, HttpServletRequest request, Model model) {
        request.setAttribute("user", userServiceImpl.findUserById((Integer.parseInt(id))));
        model.addAttribute("user", userServiceImpl.findUserById((Integer.parseInt(id))));
        return "editUser";
    }
    
    
    //根据id删除用户
    @RequestMapping(value = "/delUser/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String id) {
        userServiceImpl.deleteUser((Integer.parseInt(id)));
        return "redirect:/demo/getAllUser";
    }
    
    @RequestMapping("/getAllUser")
    public ModelAndView queryAll(String page, Model model) {
        
        //每页显示条数
        int pageSize = Integer.parseInt(userPageSize);
        
        
        List<User> users = userServiceImpl.findAll();
        
        
        //查到的总用户数
        model.addAttribute("userNum", users.size());
        
        //总页数
        int pageTimes;
        if (users.size() % pageSize == 0) {
            pageTimes = users.size() / pageSize;
        } else {
            pageTimes = users.size() / pageSize + 1;
        }
        
        model.addAttribute("pageTimes", pageTimes);
        //如果没有数据，则page等于1
        if (null == page) {
            page = "1";
        }
        int startRow = (Integer.parseInt(page) - 1) * pageSize;//起始序号等于前面的页数乘以每页的条数
        users = userServiceImpl.getByLimit(startRow, pageSize);
        model.addAttribute("currentPage", Integer.parseInt(page));
        model.addAttribute("users", users);
        model.addAttribute("userList", users);
        return new ModelAndView("allUser");
    }
    
    
}