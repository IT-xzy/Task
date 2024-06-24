package jnshu.controller;

import jnshu.dao.UserDao;
import jnshu.model.User;
import jnshu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
@Controller
@RequestMapping("/user")
public class userServiceComtroller {
    @Resource
    public UserService userService;
//    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model) {
        try {
            System.out.println("进来没===================");
            List<User> list = userService.findAll();
            System.out.println("list is ===========" + list);
            model.addAttribute("code", 1);
            model.addAttribute("user", list);
        } catch (Exception e) {
            model.addAttribute("code", 0);
        }
         return "jsp/User";
    }
//    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String add(User user, Model model) {
        System.out.println("user is ===========" + user);
        int userAdd = userService.add(user);
        if (userAdd == 1) {
            System.out.println("add is ===========" + userAdd);
            model.addAttribute("code", "1");
            model.addAttribute("message", "增加成功");
                    return "jsp/User";

        } else {
            model.addAttribute("code", "0");
            model.addAttribute("message", "增加失败");
                    return "jsp/User";

        }
    }
//    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public String delete(int id, Model model) {
        int userDelete = userService.delete(id);
        if (userDelete == 1) {
            System.out.println("delete is ===========" + userDelete);
            model.addAttribute("code", "1");
            model.addAttribute("message", "删除成功");
        } else {
            model.addAttribute("code", "0");
            model.addAttribute("message", "删除失败");
        }
        return "jsp/User";
    }
//    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public String update(User user, Model model) {
        System.out.println("修改数据=====" + user);
        int userUpdate = userService.update(user);
        if (userUpdate == 1) {
            System.out.println("修改数据=====" + userUpdate);
            model.addAttribute("code", "1");
            model.addAttribute("message", "修改成功");
        } else {
            model.addAttribute("code", "0");
            model.addAttribute("message", "修改失败");
        }
        return "jsp/User";
    }
//    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String pagination(Model model, @RequestParam(value = "number", defaultValue = "1") int pageNow) {
        System.out.println("now" + pageNow);
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
        System.out.println("总页数" + totalPages);
        model.addAttribute("number", pageNow);
        model.addAttribute("prePage", prePage);
        model.addAttribute("user", users);
        model.addAttribute("nextPage", nextPage);
        model.addAttribute("totalPages", totalPages);
        return "jsp/User";
    }

}
