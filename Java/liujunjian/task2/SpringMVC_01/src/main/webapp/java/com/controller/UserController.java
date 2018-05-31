package com.controller;

import com.pojo.Page;
import com.pojo.User;
import com.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserController {
    @Autowired
    UserDaoService userDaoService;//service类
    @Autowired
    Page p;//页面类

    //查询
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findUser(String condition, Model model) throws Exception {
        if (condition != null && condition != "") {
            try {
                Integer id = Integer.parseInt(condition);
//                输入的数字小于10000判断其为id，大于10000判断其为number
                if (id < 10000) {
                    //查询结果是User对象,添加到集合里面
                    List<User> list = new ArrayList();
                    User user = userDaoService.findUserById(id);
                    if (user != null)
                        list.add(user);
//                    返回方法在下面定义
                    return result(list, model);
                } else {
                    List<User> list = userDaoService.findUserByNumber(condition);
//                    返回方法在下面定义
                    return result(list, model);
                }
            } catch (NumberFormatException e) {
                List<User> list = userDaoService.findUserByName(condition);
//                返回方法在下面定义
                return result(list, model);
            }
        } else {
            model.addAttribute("message", "查询条件不能为空!");
            return "message";
        }
    }

    //查询结果的返回方法
    private String result(List<User> list, Model model) {
        if (!list.isEmpty()) {
            model.addAttribute("list", list);
            return "findResults";
        } else {
            model.addAttribute("message", "没有查到您要的用户");
            return "message";
        }
    }

    //添加
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(User user, Model model) {
        Long time = System.currentTimeMillis();
        user.setCreate_at(time);
        user.setUpdate_at(time);
        int id = userDaoService.insertUser(user);
        if (id > 0) {
//            userDaoService.insertUser(user)方法的返回值是新增的用户的id
            model.addAttribute("message", "添加用户成功!序号是：" + id);
            return "message";
        } else {
            model.addAttribute("message", "添加失败！");
            return "message";
        }
    }

    //删除
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteUser(int id, int page, Model model) {
//            userDaoService.deleteUser(id)的返回值是true或者false
        if (userDaoService.deleteUser(id) == true) {
            model.addAttribute("page", page);
            return "redirect:/user/page";
        } else {
            model.addAttribute("message", "删除失败！");
            return "message";
        }
    }

    //    跳转到修改页面
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public String toUpdate(int id, Model model) throws Exception {
        model.addAttribute("user", userDaoService.findUserById(id));
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateUser(User user, Model model) {
        Long time = System.currentTimeMillis();
        user.setUpdate_at(time);
//            userDaoService.updateUser(user)的返回值是true或者false
        if (userDaoService.updateUser(user) == true) {
            model.addAttribute("message", "修改成功！");
            return "message";
        } else {
            model.addAttribute("message", "修改失败！");
            return "message";
        }
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String findUsersByPage(int page, Model model) {
        try {
            p.setTotalUsers(userDaoService.findUsers().size());
            p.setCurrentPage(page);
            List<User> list = userDaoService.findUsersByPage((page - 1) * p.getPageSize(), p.getPageSize());
//            查询结果是list集合
            model.addAttribute("list", list);
            model.addAttribute("page", p);
            return "home";
        } catch (Exception e) {
            model.addAttribute("message", "未能获取数据");
            return "message";
        }
    }
}

