package Task4.controller;

import Task4.pojo.User;
import Task4.rmi.RandomService;
import Task4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@org.springframework.stereotype.Controller
@RequestMapping
public class HomeController {

    @Autowired
    RandomService randomService;


    @RequestMapping("/index")
    public String toLogin() {
        return ("index");
    }




    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView number(){
        UserService userService=randomService.getUserService();
        ModelAndView mav =new ModelAndView();
        String title= "首页";
        int work;
        int study;
        int all;
        work = userService.findByWork();
        study = userService.findByStudy();
        all = userService.findAll();
        User user1 =userService.findById(1);
        User user2 =userService.findById(2);
        User user3 =userService.findById(3);
        User user4 =userService.findById(4);
        mav.addObject("title",title);
        mav.addObject("value1",work);
        mav.addObject("value2",study);
        mav.addObject("value3",all);
        mav.addObject("user1",user1);
        mav.addObject("user2",user2);
        mav.addObject("user3",user3);
        mav.addObject("user4",user4);
        mav.setViewName("home");
        return mav;
    }
    @RequestMapping("/test")
    public String test() {
        return ("test");
    }

    @RequestMapping("/test1")
    public String test1() {
        return ("test1");
    }

    @RequestMapping("/test2")
    public String test2() {
        return ("test2");
    }

    @RequestMapping("/test3")
    public ModelAndView test3() {
        ModelAndView mav = new ModelAndView();
        String body = "companybody";
        mav.addObject("body",body);
       return mav;
    }
}
