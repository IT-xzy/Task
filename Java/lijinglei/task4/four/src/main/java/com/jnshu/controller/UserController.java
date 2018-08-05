package com.jnshu.controller;

import com.jnshu.model.ExcellentStudent;
import com.jnshu.model.JobInfo;
import com.jnshu.model.StudentNum;
import com.jnshu.model.User;
import com.jnshu.service.ESService;
import com.jnshu.service.JIService;
import com.jnshu.service.SNService;
import com.jnshu.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private ESService eSService;

    @Autowired
    private JIService jIService;

    @Autowired
    private SNService sNService;

    @Autowired
    private UserService userService;
    private Logger logger = Logger.getLogger(UserController.class);



 /*   //   跳转到登录
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toLogin() {
        return "/index";
    }
*/

    /**
     * 根据id查找
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        try {
            long timeStamp = System.currentTimeMillis();
            System.out.println(timeStamp);
            request.setAttribute("time", timeStamp);
            System.out.println("首页");
            List<ExcellentStudent> student = eSService.listAll();
            StudentNum num = sNService.findById(1);
            System.out.println(num.getCumulativeNum());
            request.setAttribute("student",student);
            request.setAttribute("num", num);
            logger.info("获取数值成功");
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("信息载入失败！具体异常信息：" +e.getMessage());
            request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            return "result";
        }
    }


    /**
     * 根据id查找
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/vocation", method = RequestMethod.GET)
    public String vocation(HttpServletRequest request) {
        try {
            long timeStamp = System.currentTimeMillis();
            System.out.println(timeStamp);
            request.setAttribute("time", timeStamp);
            System.out.println("职业");
            List<JobInfo> info =jIService.listAll();
            request.setAttribute("info",info);
            logger.info("获取数值成功");
            return "vocation";
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
            logger.error("信息载入失败！具体异常信息：" +e.getMessage());
            request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            return "result";
        }
    }

    /**
     * 登录
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String login(User user, HttpServletRequest request) {
        try {
            System.out.println("------login--qian----" + user.getId() + "," + user.getUserName() + ".");
            User loginUser = new User();
            loginUser = userService.login(user);
            if (loginUser != null) {
                request.setAttribute("loginUser", loginUser.getUserName());
                return "index";
            } else {
                request.setAttribute("loginUser", "登录失败");
                return "loginagain";
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "登录失败！具体异常信息：" + e.getMessage());
            return "result";
        }
    }
    /**
     * 分页查询
     *
     * @param pageNo
     * @param SHOW_ITEMS
     * @param request
     * @return
     *//*
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public String getPage(int pageNo, int SHOW_ITEMS, HttpServletRequest request) {

        try {
            System.out.println(pageNo);
            System.out.println(SHOW_ITEMS);
            int countAll = eSService.countAll();
            List<User> list = eSService.getPage((pageNo - 1) * SHOW_ITEMS, SHOW_ITEMS * 1);
            int totalPageNo;
            if (0 == countAll % SHOW_ITEMS) {
                totalPageNo = countAll / SHOW_ITEMS;
            } else {
                totalPageNo = countAll / SHOW_ITEMS + 1;
            }
            System.out.println(countAll);
            System.out.println(totalPageNo);
            System.out.println("------User_list-----" + list.size());
            request.setAttribute("pageNo", pageNo);
            request.setAttribute("SHOW_ITEMS", SHOW_ITEMS);
            request.setAttribute("countAll", countAll);
            request.setAttribute("addLists", list);
            request.setAttribute("totalPageNo", totalPageNo);
            logger.info("page");
            return "page";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            return "result";
        }
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String json(int id, HttpServletRequest request) {
        try {
            System.out.println(id);
            User user = eSService.findById(id);
            request.setAttribute("user", user);
            return "json";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            return "result";
        }
    }*/


}