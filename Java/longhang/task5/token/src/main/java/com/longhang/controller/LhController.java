package com.longhang.controller;

import com.longhang.model.User;
import com.longhang.server.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LhController {
    @Resource
    private UserService userSe;
    @RequestMapping(value = "/toregist")
    public String go(){
        return "regist";
    }
    @RequestMapping(value = "")
    public String g(){
        return "login";
    }
    /**
     * 登录 生成cookie
     */
    @RequestMapping(value = "/logins",method = RequestMethod.POST)
        public ModelAndView get(HttpServletRequest request){
        String s1=request.getParameter("name");
        Long thisTime=System.currentTimeMillis();
        userSe.getUpdataByName(s1,thisTime);//更改登录时间
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("time",thisTime);
        modelAndView.addObject("name",s1);
          return modelAndView;
          }
/**
 * 注册
 */
    @RequestMapping(value="/regist",method = RequestMethod.POST)
    public String regist(String name,String password,String phone){
        Long create_at=System.currentTimeMillis();
        Long logintime=create_at;
        userSe.getInsert(name,password,phone,create_at,logintime);
        return "login";
    }
    /**
     * 登出
     */
  //  @MyAnno
    @RequestMapping(value="/u/users")
    public String out(HttpServletRequest request) {
        Long time = System.currentTimeMillis();
        System.out.println("登出时间："+time);
       String userName = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if ("userName".equals(c.getName()))
                    userName = c.getValue();
                    //c.setMaxAge(0);
                System.out.println("www"+123);
                userSe.getUpdataByName1(userName, time);
                }
        }
        return "out";
    }
    /**
     * 获取需要修改的注册用户
     */
   // @MyAnno
    @RequestMapping(value="/u/user",method = RequestMethod.GET)
    public String getEditUser(HttpServletRequest request,Model model){
        String userName = null;
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookie) {  // 遍历Cookie
                if ("userName".equals(c.getName()))
                    userName = c.getValue();
                }
        }
        String s=userName;
        User u=userSe.getSelects(s);
        System.out.println(u.toString());
        model.addAttribute("user",u);
        return "editUser";
    }
/**
 * 修改的注册用户
 */
     //@MyAnno
     //@ResponseBody()
    @RequestMapping(value="/u/user",method = RequestMethod.PUT)
         public String editUser(String name,String password,String phone,Long id) {
         userSe.getUpdate(name,password,phone,id);
         System.out.println("123321");
         return "redirect:/u/use";
     }
    /**
     * 修改的注册用户,重定向在拦截器中由于cookie更改直接在拦截器中跳转再登录
     */
    //@ResponseBody()
    @RequestMapping(value="/u/use")
    public String wellcom(){
         return "t11";
    }
    @RequestMapping(value="/use")
    public String wellcom1(){
        return "t10";
    }

}
