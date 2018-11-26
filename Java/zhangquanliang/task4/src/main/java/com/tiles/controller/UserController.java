package com.tiles.controller;

import com.tiles.pojo.Page;
import com.tiles.pojo.User;
import com.tiles.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author suger
 * @date 2018/11/20 14:53
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    private static Logger logger = Logger.getLogger(UserController.class);


    @RequestMapping(value = "/u/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response){
        return "login";
    }

    @RequestMapping(value = "/u/logout",method = RequestMethod.GET)
    public String logout(HttpSession session,HttpServletRequest request, HttpServletResponse response){
        // 清除session
        session.invalidate();
       /* Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("isLogin")) {
                cookie.setValue(null);
                cookie.setMaxAge(0);// 立即销毁cookie
                response.addCookie(cookie);
                break;
            }
        }*/
        return "redirect:/home";
    }

    /**
     * 登陆
     * @param model
     * @param user
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/u/login",method =RequestMethod.POST)
    public String login(Model model, User user, HttpServletRequest request, HttpServletResponse response, HttpSession session){

        logger.info("登录信息："+user.toString());

        String  message = null;

        if (user != null) {
            User userInfo = userService.getUserByName(user.getName());
            logger.info("userInfo：" + userInfo);
            if (userInfo != null) {
                String pwd = user.getPwd();
                logger.info("输入的密码" + pwd);

                if (pwd.equals(userInfo.getPwd())) {

                    String name = user.getName();
                    // 在session中保存信息
                    session.setAttribute("USER_SESSION", name);
                    session.setMaxInactiveInterval(30 * 60);

                    // 在cookie 中保存信息
                    //Cookie cookie = new Cookie("isLogin",name);
                    // 设置为30 分钟
                    //cookie.setMaxAge(30*60);
                    //response.addCookie(cookie);

                    return "redirect:/u/user";
                } else {
                    message = "密码错误或用户名无效！请重新输入！";
                }

            } else {
                message = "用户名错误，找不到此用户！";
            }
        }else{
            message = "无此用户，请重新输入";
        }
        model.addAttribute("msg",message);
        return "login";
    }

    @RequestMapping("/u/reg")
    public String goReg(){
        return "reg";
    }

    @RequestMapping(value = "/u/reg",method =RequestMethod.POST)
    public String reg(User user,Model model,HttpServletRequest request, HttpServletResponse response){

        logger.info("注册信息："+user.toString());

        String name = user.getName();
        String pwd = user.getPwd();

        String message = null;

        // 判定输入用户名或者密码是否为空，若其中一项为空，则返回注册页面
        if(name.isEmpty() || pwd.isEmpty()){
            message = "用户名或者密码不能为空";
            model.addAttribute("msg",message);
            return "reg";
        }

        User user1 = userService.getUserByName(name);

        logger.info("----注册------查询到数据表内信息："+user1);

        if(user1!=null){
            message = "用户已经存在！请重新输入！";
        }else {
            logger.info("未查询到用户信息，开始注册");
            userService.insertUser(user);
           // message = "注册成功，请登录";
            return "login";
        }

        model.addAttribute("msg",message);
        return "reg";
    }

    // 分页查询全表
    @RequestMapping(value = "/u/user", method = RequestMethod.GET)
    public ModelAndView listUser(Page page)  throws Exception {
        int total = userService.total();
        page.calculateLast(total);
        List<User> users = userService.findAll(page);

        ModelAndView mav = new ModelAndView();
        if(users==null || users.isEmpty()){
            logger.info("查询失败，用户列表为空");
        }else{
            logger.info("查询成功----");
        }

        mav.addObject("users", users);
        //指定视图
        mav.setViewName("listUser");
        return mav;
    }
    @RequestMapping(value = "/u/user/", method = RequestMethod.GET)
    public ModelAndView getUser(@RequestParam(value = "name",required = false) String name){
        logger.info("name:"+name);
        List<User> users = userService.getUser(name);

        ModelAndView mav = new ModelAndView();
        if(users==null || users.isEmpty()){
            logger.info("查询失败，用户列表为空");
        }else{
            logger.info("查询成功----");
        }

        mav.addObject("users", users);
        //指定视图
        mav.setViewName("getUser");
        return mav;
    }

    // 根据姓名查询，支持模糊查询
    @RequestMapping(value = "/u/user/name/", method = RequestMethod.GET)
    public ModelAndView getUserByName(@RequestParam String name) throws Exception {

        ModelAndView mav = new ModelAndView("redirect:/u/user");

        logger.info("姓名:"+name);
        User user = userService.getUserByName(name);
        mav.addObject("users", user);
        return mav;
    }

    // 删除
    @RequestMapping(value = "/u/user/{id}", method = RequestMethod.DELETE)

    public String deleteUser(@PathVariable Long id,Model model) {
        logger.info("删除记录的id:"+id);
        boolean deleteTag = userService.deleteUser(id);
        logger.warn("删除结果："+deleteTag);
        return "redirect:/u/user";
    }

    // 根据id 查询
    @RequestMapping(value = "/u/user/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable Long id,Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("s", user);
        return "updateUser";
    }


    // 更新
    @RequestMapping(value = "/u/user", method = RequestMethod.PUT)
    public ModelAndView updateUser(User User) {
        ModelAndView mav  = new ModelAndView();
        if(User.getId()==null){
            logger.info("id不存在，添加信息");
            mav.addObject("message","更新失败");
        }else {
            logger.info("id已经存在，更新信息");
            boolean tag = userService.updateUser(User);
            if(tag){
                mav.addObject("message","更新成功");
            }else{
                mav.addObject("message","更新失败");
            }
        }
        mav.setViewName("redirect:/u/user");
        return mav;
    }



}
