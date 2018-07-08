package com.task2.controller;

import com.task2.pojo.Page;
import com.task2.pojo.User;
import com.task2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping(value = "/mvc")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    Page p;


    @RequestMapping(value = "/page",method=RequestMethod.GET)

    public  String page(  @ModelAttribute ("pageId") int pageId, Model model) {

        try {
            p.setCount(userService.findUserCount());
            p.setCurrentPage(pageId);
            List<User> list = userService.findUserByPage((pageId - 1) * 5, 5);
            model.addAttribute("list", list);
            model.addAttribute("page", p);
            return "userList";
        } catch (Exception e) {
            model.addAttribute("pageId", 1);
            model.addAttribute("message", "跳转失败");
            return "message";
        }


    }

    @RequestMapping(value = "/addUser",method=RequestMethod.POST)
    public String addUser( User user, int pageId,int pageCount, RedirectAttributes model) {
        userService.insertUser(user);
        if (user.getId()>0) {
            model.addFlashAttribute("message", "添加成功");
            if(pageCount%5==0){
                model.addFlashAttribute("pageId", pageId+1);
            }else {
                model.addFlashAttribute("pageId", pageId );
            }

            return "redirect:/mvc/page";
        } else {
            model.addAttribute("message", "添加失败");
            model.addAttribute("pageId", 1);
            return "message";
        }

    }

    @RequestMapping(value = "/edit")
    public String edit(long id,int pageId, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("pageId", pageId);
        return "edit";
    }
    @RequestMapping(value = "/putUser",method = RequestMethod.PUT)
    public String putUser(User user,int pageId,RedirectAttributes model) {
        if (userService.updateUser(user)) {
            model.addAttribute("message", "修改成功");
            model.addAttribute("pageId", pageId);
            return "redirect:/mvc/page";
        }else {
            model.addAttribute("message", "修改失败");
            model.addAttribute("pageId", pageId);
            return "message";
        }
    }

    @RequestMapping(value = "/delUser",method = RequestMethod.DELETE)
    public String delUser(long id, int pageId,RedirectAttributes model) {
        if (userService.deleteUserById(id)) {
            model.addAttribute("message","删除成功");
            model.addAttribute("pageId", pageId);
            return "redirect:/mvc/page";
        }else {
            model.addAttribute("message", "删除失败");
            model.addAttribute("pageId", pageId);
            return "message";
        }
    }
//综合查询
    @RequestMapping(value = "/getUserAll",method=RequestMethod.GET)
    public String getUserAll(String id,String name,String qq,String type,Model model) {
        User user=new User();
//        判断地址不为空同时不为空字符串

//        if ((id!=null&&id.length()!=0))

//        判断值是否为控制符串
        if( !(id.equals("")))
        {

            long i = Long.parseLong(id);//String类型转换为long类型

            user.setId(i);
        }


        user.setName(name);
        user.setQq(qq);
        user.setType(type);

     List<User> users=  userService.selectUser(user);
        if ( !users.isEmpty()) {
            model.addAttribute("Users", users);
            return "show";

        }else{
            model.addAttribute("message", "查询不存在");
            model.addAttribute("pageId", 1);
            return "message";
        }

    }


}
