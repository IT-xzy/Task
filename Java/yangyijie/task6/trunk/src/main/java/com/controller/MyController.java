package com.controller;

import com.bean.GoodStudent;
import com.bean.User;
import com.service.IGoodStudentService;
import com.service.IJobsService;
import com.service.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Arike
 * Create_at 2017/12/26 20:04
 */
@Controller
public class MyController {
    @Autowired
    IGoodStudentService goodStudentServiceImpl;
    @Autowired
    IJobsService jobsServiceImpl;
    @Autowired
    UserServiceImpl userServiceImpl;
    
    /**
     * 首页
     * @param model 用于给页面使用的模型
     * @return 返回tiles框架里的definition的name
     */
    @RequestMapping(value = "/u/jnshu", method = RequestMethod.GET)
    public String jnshu(ModelMap model) {
        List<GoodStudent> list = goodStudentServiceImpl.selectAll();
        model.addAttribute("list", list);
        model.addAttribute("count", goodStudentServiceImpl.count());
        model.addAttribute("countGood", goodStudentServiceImpl.countGood());
        return "jnshu";
    }
    
    /**
     * 职业列表
     * @param model 用于返回给页面使用的模型
     * @return 返回tiles框架里的definition的name
     */
    @RequestMapping("/u/joblist")
    public String job(ModelMap model) {
        model.addAttribute("joblist", jobsServiceImpl.selectJobs());
        return "joblist";
    }
    
    /**
     * 关于页面
     * @return 返回tiles框架里的definition的name(该页面没有动态资源)
     */
    @RequestMapping("/u/cooperation")
    public String cooperation() {
        return "cooperation";
    }
    
    /**
     * 登陆页面
     * @return 返回login页面
     */
    @RequestMapping(value = "/l/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    
    /**
     * 登陆按钮的URL
     * @param response 用于给与(响应)页面cookie使用
     * @param session  用于记录与cookie验证的key/value以及记录用户的用户名用于页面显示
     * @param model 返回给页面使用显示账密错误情况
     * @param user 接收用户输入的账户名以及密码用于验证登陆
     * @return
     */
    @RequestMapping(value = "/loginPage", method = RequestMethod.POST)
    public String checkLogin(HttpServletResponse response, HttpSession session, ModelMap model, User user) {
        if (userServiceImpl.checkLogin(user,response,session)) {
            return "redirect:/u/jnshu";
        } else {
            model.addAttribute("intro", "用户名或密码错误,请重新登陆");
            return "redirect:/login";
        }
    }
    
    /**
     *
     * @param request 用以获取cookie和session对象,并清除cookie以及session的值.
     * @return
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String delCookie(HttpServletRequest request) {
//        WebUtils.getCookie(request, "key").setValue(null);
        request.getSession().invalidate();
        return "redirect:/l/login";
    }
    
    /**
     * 注册按钮的URL
     * @param user 接收用户填写的注册信息
     * @return
     */
    @RequestMapping(value = "/regUser", method = RequestMethod.POST)
    public String regUser(User user,ModelMap model) {
        userServiceImpl.insertUser(user,model);
        return "regUser";
    }
    
    /**
     * 尝试了一下json对象的使用
     * @return 范围一个json
     */
    @RequestMapping(value = "/json",method = RequestMethod.GET)
    public @ResponseBody Map json(){
        HashMap<String,Object> jsonObject = new HashMap<>();
        int[]arr = {1,2,3,4,5};
        jsonObject.put("name", 1);
        jsonObject.put("arr",arr);
        return jsonObject;
    }
}