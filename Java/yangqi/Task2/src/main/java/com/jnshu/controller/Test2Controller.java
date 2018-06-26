/*

package com.jnshu.controller;


import com.jnshu.entity.User;
import com.jnshu.service.YserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/op")
public class Test2Controller {

    @Autowired
    private YserService yserService;

    @RequestMapping(value = "/yangqi",method = RequestMethod.GET)
    public String yangqi(User user,Model model)throws Exception{
        //调用数据库方法
        List<User> user1 = yserService.queryUser(user);
        //返回视图
        model.addAttribute("fast",user1);
        //返回到jsp页面
        return "home";
    }

    @RequestMapping(value = "add",method = RequestMethod.PUT)
        public String  add(User user)throws Exception{
        System.out.println(user);
        yserService.addUser(user);
        return "redirect:/op/yangqi/";
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id)throws Exception{
        System.out.println(id);
       return yserService.deleteUser(id);

    }

    @RequestMapping(value = "up",method = RequestMethod.GET)
    public String  queryId(@PathVariable int id,Model model)throws Exception{
        User user1=yserService.queryId(id);
       model.addAttribute("fast",user1);
       return "update";
    }
    @RequestMapping(value = "up{id}",method = RequestMethod.POST)
    public String updateuser(@PathVariable int id,User user)throws Exception{
        System.out.println(user.toString());
        yserService.updateId(id,user);
        return "redirect:/op/yangqi/";
    }



}
*/
