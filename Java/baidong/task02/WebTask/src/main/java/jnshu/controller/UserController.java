package jnshu.controller;

import jnshu.model.User;
import jnshu.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    public UserService userService;
//    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model) {
        logger.info("listuser方法被调用");
        try {
            List<User> list = userService.findAll();
            model.addAttribute("code", 1);
            model.addAttribute("user", list);
         logger.info("listuser方法被调用完毕");
        } catch (Exception e) {
            model.addAttribute("code", 0);
            logger.warn("listuser方法被调用出现错误");
        }
         return "jsp/User";
    }
//    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String add(User user, Model model) {
        logger.info("adduser方法被调用");
        int userAdd = userService.add(user);
        if (userAdd == 1) {
            model.addAttribute("code", "1");
             logger.info("adduser方法被调用完毕");
                    return "jsp/User";

        } else {
            model.addAttribute("code", "0");
             logger.warn("adduser方法被调用错误");
                    return "jsp/User";

        }
    }
//    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public String delete(int id, Model model) {
        logger.info("deleteuser方法 被调用");
        int userDelete = userService.delete(id);
        if (userDelete == 1) {
            model.addAttribute("code", "1");
            logger.info("deleteuser方法 被调用完毕");
        } else {
            model.addAttribute("code", "0");
            logger.warn("deleteuser方法错误");
        }
        return "jsp/User";
    }
    //    @ResponseBody
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public String update(int id, Model model) {
        logger.info("find方法 被调用");
        System.out.println("查找" + id + "行");
        User userFindById = userService.findById(id);
        model.addAttribute("find", userFindById);
        System.out.println("findnoe is ===========" + userFindById);
       logger.info("find方法 被调用完毕");
        return "jsp/update";
    }
//    //@ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public String update(User user, Model model) {
        logger.info("update方法 被调用");
        int userUpdate = userService.update(user);
        if (userUpdate == 1) {
            model.addAttribute("code", "1");
            logger.info("update方法 被调用完毕");
        } else {
            model.addAttribute("code", "0");
             logger.warn("update方法 被调用失败");
        }
        return "jsp/User";
    }
//    @ResponseBody
    @RequestMapping(value = "/users/page", method = RequestMethod.GET)
    public String pagination(Model model, @RequestParam(value = "number", defaultValue = "1") int pageNow) {
        logger.info("page方法 被调用");
        try {

            int prePage;
            int nextPage;
            int pageSize = 10;
            int allRow = userService.selectCount();
            int totalPages = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
            if (pageNow > 1) {
                prePage = pageNow - 1;
            } else {
                prePage = pageNow;
            }
            if (pageNow < totalPages) {
                nextPage = pageNow + 1;
            } else {
                nextPage = pageNow;
            }
            List<User> users = userService.selectPage((pageNow - 1) * 10, 10);
            model.addAttribute("number", pageNow);
            model.addAttribute("prePage", prePage);
            model.addAttribute("user", users);
            model.addAttribute("nextPage", nextPage);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("code", 1);
            logger.info("page方法 被调用完毕");
        }catch (Exception e){
            model.addAttribute("code", 0);
            logger.warn("page方法 被调用失败");
        }
        return "jsp/User";
    }

}
