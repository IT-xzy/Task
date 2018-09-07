package com.jnshu.controller;

import com.jnshu.model.User;
import com.jnshu.service.UserService;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private Logger logger = Logger.getLogger(UserController.class);

    //    添加学员跳转页
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAddStudent() {

        return "add";

    }

    //   返回首页
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String toIndex() {
        return "index";
    }

    //   跳转到findById
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String toFindById() {
        return "find";
    }

    //   跳转到登录
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    /**
     * 增加信息
     *
     * @param user
     * @param request
     * @return
     */
    @SuppressWarnings("finally")
    @RequestMapping(value = "/addInfo", method = RequestMethod.POST)
    public String add(User user, HttpServletRequest request) {
        try {
            logger.info("新增数据");
            System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getQq()
                    + "\t" + user.getStudyType() + "\t" + user.getEnrollment() + "\t" + user.getGraduateSchool()
                    + "\t" + user.getStudentNum() + "\t" + user.getDailyLink() + "\t" + user.getWish()
                    + "\t" + user.getCheckBro() + "\t" + user.getKnowWay());
            String str = userService.addInfo(user);

            System.out.println(str);
            request.setAttribute("InfoMessage", str);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "添加信息失败！具体异常信息：" + e.getMessage());
        } finally {
            return "result";
        }
    }

    /**
     * 根据id查找
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/idResult", method = RequestMethod.GET)
    public String find(int id, HttpServletRequest request) {
        try {
            logger.info("根据id查找");
            System.out.println(id);
           User user = userService.findById(id);
            request.setAttribute("id", id);
            request.setAttribute("find", user);
            return "find";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            return "result";
        }
    }

    /**
     * 删除
     *
     * @param id
     * @param request
     * @return
     */
    @SuppressWarnings("finally")
    @RequestMapping(value = "/student/del/id={id}", method = RequestMethod.POST)
    public String del(@PathVariable int id, HttpServletRequest request) {
        try {
            logger.info("删除数据");
            String str = userService.delete(id);
            request.setAttribute("InfoMessage", str);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "删除信息失败！具体异常信息：" + e.getMessage());
        } finally {
            return "result";
        }
    }


    /**
     * 修改
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/student/id={id}", method = RequestMethod.GET)
    public String modify(@PathVariable int id, HttpServletRequest request) {
        try {
            logger.info("修改跳转");
            User user = userService.findById(id);
            request.setAttribute("add", user);
            return "modify";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            return "result";
        }
    }

    /**
     * 更新
     *
     * @param user
     * @param request
     * @return
     */
    @SuppressWarnings("finally")
    @RequestMapping("update")
    public String update(User user, HttpServletRequest request) {
        try {
            logger.info("更新数据");
            String str = userService.update(user);
            request.setAttribute("InfoMessage", str);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "更新信息失败！具体异常信息：" + e.getMessage());
        } finally {
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
            logger.info(user.getName()+"登录");
            User loginUser = new User();
            loginUser = userService.login(user);
            if (loginUser != null) {
                request.setAttribute("loginUser", loginUser.getName());
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
     */
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public String getPage(int pageNo, int SHOW_ITEMS, HttpServletRequest request) {
        logger.info("分页查询");
        logger.info("第"+pageNo+"页，每页"+SHOW_ITEMS+"行");
        try {
            int countAll = userService.countAll();
            int totalPageNo;
            if (0 == countAll % SHOW_ITEMS) {
                totalPageNo = countAll / SHOW_ITEMS;
            } else {
                totalPageNo = countAll / SHOW_ITEMS + 1;
            }
            List<User>  list = userService.getPage((pageNo - 1) * SHOW_ITEMS, SHOW_ITEMS * 1);
            System.out.println(countAll);
            System.out.println(totalPageNo);
            System.out.println("------User_list-----" + list.size());
            request.setAttribute("pageNo", pageNo);
            request.setAttribute("SHOW_ITEMS", SHOW_ITEMS);
            request.setAttribute("countAll", countAll);
            request.setAttribute("addLists", list);
            request.setAttribute("totalPageNo", totalPageNo);
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
            logger.info("json数据");
            User user =userService.findById(id);
            request.setAttribute("user", user);
            return "json";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
            return "result";
        }
    }

}